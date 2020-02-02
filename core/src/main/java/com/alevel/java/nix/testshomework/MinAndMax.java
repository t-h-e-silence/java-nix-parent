package com.alevel.java.nix.testshomework;

public class MinAndMax {

    int [] arr;


    public MinAndMax(int[] arr) {
        this.arr=arr;

    }

    public int min() {

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min> arr[i]) {
                min = arr[i];
            }

        }
        return min;
    }

    public int max() {

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max< arr[i]) {
               max = arr[i];

            }

        }
        return max;
    }
}
