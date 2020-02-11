package com.alevel.java.nix.classpractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigzagConversionTest {

    @Test
    void convertToZigzag() {

        String expect="pahnaplsiigyir";
        ZigzagConversion z= new ZigzagConversion();
        String actual= z.convertToZigzag(3);
        assertEquals(expect, actual);
    }
}
