package com.alevel.java.nix.leetcodepractice;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;

public class MedianaOfArrays {

    public double mediana(int[] num1, int[] num2) {
        if (num1.length == 0 || num2.length == 0) {
            return 0;
        }
        int[] arr;
        int len1 = num1.length;
        int len2 = num2.length;

        if (len1 > len2) {
            arr = num1;
            num1 = num2;
            num2 = arr;
        }
        int min = 0;
        int max = num1.length;
        int mid = ((num1.length + num2.length + 1) / 2);
        int i = 0, j = 0;
        while (min <= max) {
            i = (min + max) / 2;
            j = mid - i;
            if (i < num1.length && num2[j - 1] > num1[i]) {
                min = i + 1;
            } else if (i > 0 && num1[i - 1] > num2[j]) {
                max = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = num2[j - 1];
                } else if (j == 0) {
                    maxLeft = num1[i - 1];
                } else maxLeft = Math.max(num1[i - 1], num2[j - 1]);

                if ((num1.length + num2.length) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == num1.length) {
                    minRight = num2[j];
                } else if (j == num2.length) {
                    minRight = num1[i];
                } else minRight = Math.min(num1[i], num2[j]);
                return (maxLeft + minRight) / 2;
            }
        }
        return 0;
    }
}
