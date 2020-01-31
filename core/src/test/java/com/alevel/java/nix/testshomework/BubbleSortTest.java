package com.alevel.java.nix.testshomework;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        BubbleSort b =new BubbleSort(new int[]{1, 2, 3, 4, 5});
        int [] barr=b.Sort();
        BubbleSort b1 = new BubbleSort(new int[]{-10, 100, 2, 39, 4, 5});
        int [] barr1=b1.Sort();
        BubbleSort b2 = new BubbleSort(new int[]{666, 100, 2, 399, -44, -58});
        int [] barr2=b2.Sort();

        assertArrayEquals(new int[]{1, 2, 3, 4, 5},barr);
        assertArrayEquals(new int[]{-10, 2, 4, 5, 39, 100},barr1);
        assertArrayEquals(new int[]{-58, -44, 2, 100, 399, 666},barr2);
    }
}