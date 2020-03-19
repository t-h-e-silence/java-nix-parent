package com.alevel.java.nix.collections;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StringDigitTest {


    @Test
    void strConvert() {
        StringDigit s=new StringDigit();
        ArrayList<String> str=new ArrayList<>();
        str.add("String 1 text");
        str.add("2 str 3");
        str.add("9 dfd1");
        int res= s.strConvert(str);
        assertEquals(12391,res);
        ArrayList<String> str1=new ArrayList<>();
        int res1 = s.strConvert(str1);
        assertEquals(0,res1);
    }
}