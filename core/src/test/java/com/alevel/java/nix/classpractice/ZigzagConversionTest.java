package com.alevel.java.nix.classpractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigzagConversionTest {

    @Test
    void convertToZigzag() {

        String actual="pahnaplsiigyir";
        ZigzagConversion z= new ZigzagConversion();
        String expect= z.convertToZigzag(3);
        assertEquals(expect, actual);
    }
}