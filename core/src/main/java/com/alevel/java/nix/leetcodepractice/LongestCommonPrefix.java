package com.alevel.java.nix.leetcodepractice;

public class LongestCommonPrefix {

    public String longestPrefix(String[] arr) {
        if (arr.length == 0 || arr == null) {
            return " ";
        }
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            String current = arr[i];
            int symbol = 0;
            while ((symbol < current.length()) && (symbol < prefix.length())
                    && current.charAt(symbol) == prefix.charAt(symbol)) {
                symbol++;
            }
            if (symbol == 0) {
                return " ";
            } else
                prefix = current.substring(0, symbol);
        }
        return prefix;
    }
}
