package com.alevel.java.nix.classpractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubStringsTest {

    @Test
    void lengthOfSubs() {
        SubStrings s= new SubStrings("bbbb");
        int n= s.lengthOfSubs();
        assertEquals(1, n);
        SubStrings s1= new SubStrings("abdefgabef");
         n= s1.lengthOfSubs();
        assertEquals(6, n);
    }
}