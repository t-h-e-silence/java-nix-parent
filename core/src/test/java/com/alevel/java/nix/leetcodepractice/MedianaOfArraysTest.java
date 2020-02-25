package com.alevel.java.nix.leetcodepractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianaOfArraysTest {

    @Test
    void mediana() {
        MedianaOfArrays m = new MedianaOfArrays();
        int[] num1 = {2, 6, 12, 14, 25, 30};
        int[] num2 = {1, 5, 7, 8, 10};
        assertEquals(8.0,m.mediana(num1, num2));
        int[] num3={};
        int[] num4={};
        assertEquals(0.0,m.mediana(num3, num4));
        int[] num5={1,3};
        int[] num6={2};
        assertEquals(2.0,m.mediana(num5, num6));

    }
}