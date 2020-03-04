package com.alevel.java.nix.oop.task2;

public interface Substance {
    double normalTemperature = 20.0;
     State heatUp(double t);
     double getTemperature();
     double getHardTemp();
     double getLiquidTemp();
     double getGasTemp();
}
