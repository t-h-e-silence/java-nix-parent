package com.alevel.java.nix.stringpractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversStrTest {

    @Test
    void reverse() {
        ReversStr s=new ReversStr();
        CharSequence str= "dcba";
        assertEquals(str, s.reverse());

        ReversStr s1=new ReversStr("Hello World");
        str= "dlroW olleH";
        assertEquals(str, s1.reverse());
    }
}