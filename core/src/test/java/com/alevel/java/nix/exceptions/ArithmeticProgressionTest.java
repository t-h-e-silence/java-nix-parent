package com.alevel.java.nix.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticProgressionTest {

    @Test
    void calculate() throws ProgressionConfigurationException {
        ProgressionConfigurationException thrown = assertThrows(
                ProgressionConfigurationException.class,
                () -> new ArithmeticProgression(0, 0));
        assertEquals("Step cant be 0!", thrown.getMessage());
        ProgressionConfigurationException thrown1 = assertThrows(
                ProgressionConfigurationException.class,
                () -> new ArithmeticProgression(1, 2).calculate(0));
        assertEquals("N cant be 0!", thrown1.getMessage());
        ArithmeticProgression a= new ArithmeticProgression(1, 2);
        assertEquals(5,a.calculate(3));

    }
}