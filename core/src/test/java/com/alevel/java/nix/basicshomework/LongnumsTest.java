package com.alevel.java.nix.basicshomework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongnumsTest {
    @Test
    void numsOfBits() {
        Longnums l = new Longnums();
        int actual = l.numsOfBits();
        assertEquals(0, actual);
        Longnums l1 = new Longnums(1_111_122_222_333_33L);
        actual = l1.numsOfBits();
        assertEquals(22, actual);
        Longnums l2 = new Longnums(1_111_122_222_333_33L);
        actual = l2.numsOfBits();
        assertEquals(22, actual);
        Longnums l3 = new Longnums(-6_489_945_7176_598L);
        actual = l3.numsOfBits();
        assertEquals(43, actual);

        Longnums l4 = new Longnums(6_489_945_7176_598L);
        actual = l4.numsOfBits();
        assertEquals(21, actual);
    }

}