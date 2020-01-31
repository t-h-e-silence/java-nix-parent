package com.alevel.java.nix.testshomework;

public class BubbleSort {
    int [] arr;


    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    public int [] Sort() {
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++)
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                    //swap(mass[j], mass[j+1]);
                }
            }
    return arr;
}

}
