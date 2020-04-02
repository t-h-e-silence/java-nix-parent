package com.alevel.java.nix.practiceLesson19;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NumOfSymbols {

    public String textFromFile(String filename) throws IOException {
        File file = new File(filename);
        String line;
        String text = "";
        String lineSeparator = System.getProperty("line.separator");
        text += lineSeparator;
        BufferedReader in = new BufferedReader(new FileReader(filename));
        int lineCounter = 0;
        while ((line = in.readLine()) != null) {
            text += line;
            lineCounter++;
        }
        return text;
    }

    public HashMap<Character, Integer> countOfSymbols(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        int tempCount = 0;

        for (int i = 0; i < text.length(); i++) {
            if (map.containsKey(text.charAt(i))) {
                tempCount = map.get(text.charAt(i)) + 1;
                map.put(text.charAt(i), tempCount);
            } else {
                map.put(text.charAt(i), 1);
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
NumOfSymbols s=new NumOfSymbols();
String text=s.textFromFile("C://alevel-java-nix//core//src//main//java//com//alevel//java//nix//io//newFile.txt");
        System.out.println(text);
HashMap<Character,Integer> map= s.countOfSymbols(text);
        System.out.println(map);
    }

}
