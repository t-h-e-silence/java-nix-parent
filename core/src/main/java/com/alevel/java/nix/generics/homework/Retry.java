package com.alevel.java.nix.generics.homework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public  class Retry<T> implements Block<T> {

    private static final Logger log = LoggerFactory.getLogger(Retry.class);
    long startTime;
    private final int times;
    private final Block<T> block;

    public static<T>RetryBuilder<T> builder(Block<T> block) {
        return new RetryBuilder<T>(block);
    }

    Retry(int times, Block<T> block, long startTime) {
        this.times = times;
        this.block = block;
        this.startTime = startTime;
    }

    public T run() throws Exception {
        int already = 0;
        Exception exp = null;
        while (already < times) {
            already++;
            try {
                block.run();
            } catch (Exception e) {
                log.warn("Attempt {} failed", already, e);
                exp = e;
            }
            try {
                sleepTime(already);
            } catch (InterruptedException e) {
                log.warn("Backoff interrupted, proceeding to retry", e);
            }
        }

        log.error("Failed to execute the block after {} attempts", already, exp);
        throw exp;
    }

    void sleepTime(int already) throws InterruptedException {
        long millis = startTime * already;
        System.out.println("Waiting {} ms before retry");
        log.warn("Waiting {} ms before retry", millis);
        Thread.sleep(millis);
    }

    public static final class RetryBuilder<T> {
        private final Block block;
        private int times = 1;
        private long pause=0;

        private RetryBuilder(Block block)
        {
            this.block = Objects.requireNonNull(block);
        }

        public RetryBuilder<T> times(int times) {
            if (times < 1) {
                throw new IllegalArgumentException("Should retry at least 1 time, got " + times);
            }
            this.times = times;
            return this;
        }

        public RetryBuilder<T> pause(long pause) {
            if (pause < 0) {
                throw new IllegalArgumentException("Can't pause for negative amount of time, got " + pause);
            }
            this.pause = pause;
            return this;
        }

        public Block<T> build() {
            if (times == 1) return block;
            return new RetryWithPause(times, pause, block);
        }

    }
}

