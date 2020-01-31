package com.alevel.java.nix.testshomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinAndMaxTest {
    @Test
    void min() {

        MinAndMax m = new MinAndMax(new int[]{1, 2, 3, 4, 5});
        int r = m.Min();
        MinAndMax m1 = new MinAndMax(new int[]{-10, 100, 2, 39, 4, 5});
        int r1 = m1.Min();
        MinAndMax m2 = new MinAndMax(new int[]{666, 100, 2, 399, -44, -58});
        int r2 = m2.Min();

        assertEquals(1, r);
        assertEquals(-10, r1);
        assertEquals(-58, r2);
    }

    @Test
    void max() {
        MinAndMax m = new MinAndMax(new int[]{1, 2, 3, 4, 5});
        int r = m.Max();
        MinAndMax m1 = new MinAndMax(new int[]{-10, 100, 2, 39, 4, 5});
        int r1 = m1.Max();
        MinAndMax m2 = new MinAndMax(new int[]{666, 100, 2, 399, -44, -58});
        int r2 = m2.Max();

        assertEquals(5, r);
        assertEquals(100, r1);
        assertEquals(666, r2);
    }
}