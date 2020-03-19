package com.alevel.java.nix.collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringDigit {

    public int strConvert(ArrayList<String> str){
        int digit=0;
        if(str==null){
            return digit;
        }
        String builder = new String();
        List<String> numbers= str.stream().map(s -> extractDigits(s)).collect(Collectors.toList());
        for (int i=0;i<numbers.size();i++){
            builder+=numbers.get(i);
        }
        if (builder.isEmpty()) {
            return 0;
        }
        digit = Integer.parseInt(builder);
        return digit;
    }

    public String extractDigits(String src) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }

}