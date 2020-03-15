package com.alevel.java.nix.generics;

import java.io.ObjectInputStream;
import java.util.Arrays;

public class MaxAggregator<T extends Comparable<? super T>> implements Aggregator<T, T> {

    @Override
    public T aggregate(T[] items) {
        if(items==null){
            return null;
        }
        T max = items[0];
        for (int i = 1; i < items.length; i++) {
            T next = items[i];
            if (max.compareTo(next) < 0) {
                max = next;
            }
        }
        return max;
    }

}
