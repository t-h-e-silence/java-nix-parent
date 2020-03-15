package com.alevel.java.nix.generics;

import java.io.ObjectInputStream;
import java.util.HashSet;

public class DistinctAggregator implements Aggregator {
    @Override
    public Object aggregate(Object[] t) {
        if (t == null || t.length<1) {
            return 0;
        }
        HashSet<Object> a = new HashSet<>();
        int count = 0;
        int curr = 0;
        for (int i = 0; i < t.length; i++) {
            if (a.contains(t[i]) == true) {
                count = Math.max(curr, a.size());
                a.clear();
                curr = 0;
            } else {
                curr++;
                a.add(t[i]);
            }
        }
        return count;
    }
}
