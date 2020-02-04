package com.alevel.java.nix.testshomework;

import java.util.ArrayList;
import java.util.List;

public class Multiple {

    ArrayList<Integer> arr = new ArrayList<Integer>();

    public Multiple(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public int[] multiplenums(int k) {
        List<Integer> result = new ArrayList<Integer>();
        //for (int j = 0; j < arr.size(); j++) {
          //  result.add(j, arr.get(j));
        //}

        for (int i = 0; i < arr.size(); i++) {
            if ((arr.get(i)) < k) {
                arr.remove(i);
            }
            if ((arr.get(i) % k) != 0) {
                arr.remove(i);
            }
        }
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

}
