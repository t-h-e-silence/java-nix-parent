package com.alevel.java.nix.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvgAggregatorTest {

    @Test
    void aggregate() {
        AvgAggregator a = new AvgAggregator();
        Double[] o = new Double[]{1.0, 5.0, 6.0, 12.0};
        assertEquals(6, a.aggregate(o));
        Object[] o1 = new Number[]{1, 0.0, 5, 12};
        assertEquals(4.5, a.aggregate((Number[]) o1));
    }
}