package com.alevel.java.nix.generics.homework;


class RetryWithPause extends Retry {
    private final long pause;
    RetryWithPause(int times, long pause, Block block) {
        super(times, block, pause);
        this.pause = pause;
    }
}

