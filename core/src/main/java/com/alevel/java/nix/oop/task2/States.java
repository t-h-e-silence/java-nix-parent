package com.alevel.java.nix.oop.task2;

public abstract class States implements Substance {
    double liquidTemp, hardTemp, gasTemp, newTemp;
    double t;
    double temperature = normalTemperature;

    @Override
    public State heatUp(double t) {
        if (t == 0) {
            return null;
        }
        temperature = t;
        if (temperature < getLiquidTemp()) {
            return State.SOLID;
        }
        if ((temperature > getHardTemp()) && temperature < getGasTemp()) {
            return State.LIQUID;
        }

        if (temperature > getHardTemp()) {
            return State.GAS;
        }
        return null;
    }

    public double getHardTemp() {
        return hardTemp;
    }

    public double getLiquidTemp() {
        return liquidTemp;
    }

    public double getGasTemp() {
        return gasTemp;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
