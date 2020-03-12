package com.alevel.java.nix.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAggregatorTest {

    @Test
    void aggregate() {
        MaxAggregator m=new MaxAggregator();
        String[] mass= new String[]{"a", "c", "z", "w"};
       assertEquals("z", m.aggregate(mass));
        Integer[] mass1= new Integer[]{0,8,5,13,5};
        assertEquals(13, m.aggregate(mass1));
    }
}