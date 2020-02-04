package com.alevel.java.nix.basicshomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BuzzFizzTest {
    private PrintStream old;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(old);
    }

    @Test
    void leftRight() {

        BuzzFizz b = new BuzzFizz(64173);
        b.leftRight();
        assertEquals("BuzzFizz\nFizz\n1\n7\nBuzz\n", output.toString());

        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        BuzzFizz b1 = new BuzzFizz(109260);
        b1.leftRight();
        assertEquals("1\n0\nBuzz\nFizz\nBuzzFizz\n0\n", output.toString());
        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        BuzzFizz b2= new BuzzFizz();
        b2.rightLeft();
        assertEquals("1\n", output.toString());
    }

    @Test
    void rightLeft() {
        BuzzFizz b = new BuzzFizz(70632);
        b.rightLeft();

        assertEquals("7\n0\nBuzzFizz\nBuzz\nFizz\n", output.toString());
        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        BuzzFizz b1 = new BuzzFizz(66102490);
        b1.rightLeft();
        assertEquals("BuzzFizz\nBuzzFizz\n1\n0\nFizz\nFizz\nBuzz\n0\n", output.toString());
        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        BuzzFizz b2= new BuzzFizz();
        b2.rightLeft();
        assertEquals("1\n", output.toString());

    }

}