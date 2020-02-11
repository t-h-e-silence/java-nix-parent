package com.alevel.java.nix.classpractice;

public class ZigzagConversion {
    String s;

    ZigzagConversion() {
        this.s = "paypalishiring";
    }

    ZigzagConversion(String s) {
        this.s = s;
    }

    public String convertToZigzag(int rows) {
        if (s == null || rows <= 1) {
            return s;
        } else {
            char[] str = s.toCharArray();
            char[] zigzag = new char[str.length];
            int index = 2 * rows - 2;
            for (int i = 0, count = 0; i < rows; i++) {
                int n = index - 2 * i;
                for (int j = i; j < str.length; j += index) {
                    zigzag[count] = str[j];
                    count++;
                    if (n > 0 && n < index && j + n < str.length) {
                        zigzag[count] = str[j + n];
                        count++;
                    }
                }
            }
            return String.valueOf(zigzag);
        }
    }
}

