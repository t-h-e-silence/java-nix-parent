package com.alevel.java.nix.oop.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatesTest {

    @Test
    void heatUp() {
        Water w = new Water();
        assertEquals("LIQUID", String.valueOf(w.heatUp(10)));
        assertEquals("null", String.valueOf(w.heatUp(0)));
        assertEquals("GAS", String.valueOf(w.heatUp(105)));
        assertEquals("SOLID", String.valueOf(w.heatUp(-10)));
        Iron i = new Iron();
        assertEquals("SOLID", String.valueOf(i.heatUp(50)));
        assertEquals("null", String.valueOf(i.heatUp(0)));
        assertEquals("GAS", String.valueOf(i.heatUp(10005)));
        assertEquals("LIQUID", String.valueOf(i.heatUp(2000)));
        Oxygen o = new Oxygen();
        assertEquals("GAS", String.valueOf(o.heatUp(50)));
        assertEquals("null", String.valueOf(o.heatUp(0)));
        assertEquals("LIQUID", String.valueOf(o.heatUp(-190)));
        assertEquals("SOLID", String.valueOf(o.heatUp(-300)));


    }
}