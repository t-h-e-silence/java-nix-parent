package com.alevel.java.nix.testshomework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultipleTest {

    @Test
    void multiplenums() {
        ArrayList <Integer> arr = new ArrayList<Integer>();
        arr.add(2);
        arr.add(3);
        arr.add(12);
        arr.add(34);
        arr.add(21);
        arr.add(38);
        arr.add(69);
        ArrayList <Integer> arr1 = new ArrayList<Integer>();
        arr1.add(24);
        arr1.add(13);
        arr1.add(12);
        arr1.add(30);
        arr1.add(21);
        arr1.add(45);
        arr1.add(9);

        Multiple m = new Multiple(arr);
        int [] barr=m.multiplenums(2);
        Multiple m1 = new Multiple(arr1);
        int [] barr1= m1.multiplenums(3);

        assertArrayEquals(new int[]{2, 12, 34, 38},barr);
        assertArrayEquals(new int[]{24,12, 30,21,45, 9},barr1);

    }
}