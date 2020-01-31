package com.alevel.java.nix.testshomework;

import java.util.ArrayList;

public class Multiple {

    ArrayList<Integer> arr = new ArrayList<Integer>();

    public Multiple(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public int[] Multiplenums(int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int j = 0; j < arr.size(); j++) {
            result.add(j, arr.get(j));
        }

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) < k) {
                result.remove(i);
            }
            if ((result.get(i) % k) != 0) {
                result.remove(i);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
