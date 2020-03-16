package com.alevel.java.nix.exceptions.homework;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class RetryTest{

        public static final Block SUCCESS = () -> {
        };

        @Test
        @SuppressWarnings("ResultOfMethodCallIgnored")
        void shouldValidateRetryConfiguration() {
            assertThrows(NullPointerException.class, () -> Retry.builder(null));
            assertThrows(IllegalArgumentException.class, () -> Retry.builder(SUCCESS).pause(-1));
            assertThrows(IllegalArgumentException.class, () -> Retry.builder(SUCCESS).times(0));
            assertThrows(IllegalArgumentException.class, () -> Retry.builder(SUCCESS).times(-1));
        }

        @Test
        void shouldRetryImmediatelyIfNoDelaySet() {

            var retry = Retry.builder(SUCCESS).build();

            assertTimeout(Duration.ofMillis(3), retry::run);

            retry = Retry.builder(SUCCESS).pause(0).times(3).build();

            assertTimeout(Duration.ofMillis(3), retry::run);
        }

        @Test
        void shouldFailWhenAttemptsRunOut() {
            var retry = Retry.builder(new FailingBlock(3)).times(3).build();
            var failure = assertThrows(FailingBlockException.class, retry::run);
            assertEquals(0, failure.remainingFailures);

            retry = Retry.builder(new FailingBlock(4)).times(3).build();
            failure = assertThrows(FailingBlockException.class, retry::run);
            assertEquals(1, failure.remainingFailures);
        }

        @Test
        void shouldSucceedIfAttemptIsSuccessful() {
            var retry = Retry.builder(new FailingBlock(2)).times(3).build();
            assertDoesNotThrow(retry::run);

            retry = Retry.builder(new FailingBlock(0)).times(3).build();
            assertDoesNotThrow(retry::run);
        }

        @Test
        void shouldDelayRetriesIncrementally() {
            var retry = Retry.builder(new FailingBlock(2)).times(3).pause(5).build();
            assertDoesNotThrow(retry::run);

            retry = Retry.builder(new DelayedBlock(30)).times(3).pause(10).build();
            assertDoesNotThrow(retry::run);

            retry = Retry.builder(new DelayedBlock(70)).times(3).pause(10).build();
            assertThrows(DelayedBlockException.class, retry::run);
        }

        private static final class FailingBlock implements Block {

            private int failures;

            FailingBlock(int failures) {
                this.failures = failures;
            }

            @Override
            public void run() throws Exception {
                if (--failures >= 0) {
                    throw new FailingBlockException(failures);
                }
            }
        }

        private static final class DelayedBlock implements Block {

            private final long requiredDelay;

            private long timestamp;

            private DelayedBlock(long requiredDelay) {
                this.requiredDelay = requiredDelay;
                timestamp = System.currentTimeMillis();
            }

            @Override
            public void run() throws Exception {
                long time = System.currentTimeMillis();
                long delay = time - timestamp;
                if (delay < requiredDelay) {
                    throw new DelayedBlockException(delay);
                }
            }
        }

        private static final class FailingBlockException extends Exception {

            final int remainingFailures;

            public FailingBlockException(int remainingFailures) {
                super(remainingFailures + " failures remaining");
                this.remainingFailures = remainingFailures;
            }
        }

        private static final class DelayedBlockException extends Exception {

            public DelayedBlockException(long delay) {
                super("delay " + delay + " is not long enough");
            }
        }
    }