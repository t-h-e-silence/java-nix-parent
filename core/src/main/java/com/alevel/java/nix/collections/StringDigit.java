package com.alevel.java.nix.collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringDigit {

    public String strConvert(ArrayList<String> str){
        if(str==null){
            return null;
        }
        String builder = new String();
        List<String> numbers= str.stream().map(s -> extractDigits(s)).collect(Collectors.toList());
        for (int i=0;i<numbers.size();i++){
            builder+=numbers.get(i);
        }
        System.out.println(builder);
    return builder;
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
