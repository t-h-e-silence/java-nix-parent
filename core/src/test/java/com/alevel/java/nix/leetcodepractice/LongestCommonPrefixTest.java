package com.alevel.java.nix.leetcodepractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void longestPrefix() {

        String[] arr = {"flower", "flolow", "fly", "flord"};
        LongestCommonPrefix l = new LongestCommonPrefix();
        assertEquals("fl",l.longestPrefix(arr));
        String []arr1 = new String[]{};
        assertEquals(" ",l.longestPrefix(arr1));
        String []arr2 = {"sun", "cat", "car", "cartoon", "witcher"};
        assertEquals(" ",l.longestPrefix(arr2));
        String []arr3 = {"sun"};
        assertEquals("sun",l.longestPrefix(arr3));
    }
}
