package com.alevel.java.nix.arrayshomework;

import com.alevel.java.nix.basicshomework.BuzzFizz;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TransposeTest {


    @Test
    void toTranspose() {
        PrintStream old;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Transpose t = new Transpose();
        t.toTranspose();
        assertEquals("[[0, 3, 6], [1, 4, 7], [2, 5, 8]]", String.valueOf(output));
        Transpose t1 = new Transpose(new int[][]{{1, 2}, {4, 5}, {7, 8}});
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        t1.toTranspose();
        assertEquals("[[1, 4, 7], [2, 5, 8]]",  String.valueOf(output));
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Transpose t2 = new Transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
        t2.toTranspose();
        assertEquals("[[1, 4], [2, 5], [3, 6]]",  String.valueOf(output));
        }
    }
