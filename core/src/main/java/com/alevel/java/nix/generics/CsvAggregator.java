package com.alevel.java.nix.generics;


import java.util.ArrayList;
import java.util.StringJoiner;

public class CsvAggregator implements Aggregator<String, Object> {
    @Override
    public String aggregate(Object[] items) {
        if (items == null) return "";
        StringBuilder join = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            join.append(String.valueOf(items[i])).append(", ");
        }
        join.setLength(join.length() - 2);
        return join.toString();
    }
}