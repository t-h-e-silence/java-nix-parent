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

        Multiple m = new Multiple(arr);
        int [] barr=m.Multiplenums(2);
        Multiple m1 = new Multiple(arr);
        int [] barr1= m1.Multiplenums(3);

        assertArrayEquals(new int[]{2, 12, 34, 38},barr);
        assertArrayEquals(new int[]{3,12,21,69},barr1);

    }
}