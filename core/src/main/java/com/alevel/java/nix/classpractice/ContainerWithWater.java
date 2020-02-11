package com.alevel.java.nix.classpractice;

public class ContainerWithWater {

    int[] arr;

    ContainerWithWater(int[] arr) {
        this.arr = arr;
    }

    ContainerWithWater() {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8};
    }

    public int container() {
        if(arr.length==0) {
            return 0;
        }
        int min = 0;
        int max = arr.length - 1;
        int contain = 0;
        while (min < max) {
            int minside = (Math.min(arr[min], arr[max])) * (max - min);
            contain = Math.max(contain, minside);
            if (arr[min] < arr[max])
                min++;
            else
                max--;
        }
        return contain;
    }
}
