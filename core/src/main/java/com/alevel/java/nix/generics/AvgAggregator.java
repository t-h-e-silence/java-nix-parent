package com.alevel.java.nix.generics;

import java.io.ObjectInputStream;

public class AvgAggregator implements Aggregator<Double, Number> {
    @Override
    public Double aggregate(Number[] items) {
        Double avg = 0.0;
        for (int i = 0; i < items.length; i++) {
            avg += ((Number) items[i]).doubleValue();
        }
        return (Double) avg / items.length;
    }
}
