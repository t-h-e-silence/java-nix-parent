package com.alevel.java.nix.generics;

import org.junit.jupiter.api.Test;

import java.io.ObjectInputStream;

import static org.junit.jupiter.api.Assertions.*;

class DistinctAggregatorTest {

    @Test
    void aggregate() {
        DistinctAggregator  d=new DistinctAggregator();
        Object[] o=new Object[]{0, 1, "Length", 0.01, 1};
        assertEquals(4,d.aggregate(o));
        Object[] o1=new Object[]{0, "6", 0};
        assertEquals(1,d.aggregate(o1));
    }
}