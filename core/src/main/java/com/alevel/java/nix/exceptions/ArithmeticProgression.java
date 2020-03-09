package com.alevel.java.nix.exceptions;

public class ArithmeticProgression {
    private final int initial;
    private final int step;


    public ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        this.step = step;
        if (step == 0) throw new ProgressionConfigurationException("Step cant be 0!");
        this.initial = initial;

    }

    int calculate(int n) throws ProgressionConfigurationException {
        if (n == 0) {
            throw new ProgressionConfigurationException("N cant be 0!");
        }
        return initial + (n - 1) * step;
    }
}
