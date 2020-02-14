package com.alevel.java.nix.classpractice;

import java.util.HashSet;

public class SubStrings {
    String s;

    SubStrings() {
        this.s = "bbbb";
    }

    SubStrings(String s) {
        this.s = s;
    }

    public int lengthOfSubs() {
        if (s == null)
            return 0;
        HashSet<Character> subs = new HashSet<Character>();
        int count = 0;
        int curr = 0;
        char[] str = s.toCharArray(); //лучше не создавать массив, занимает память
        for (int i = 0; i < str.length; i++) {
            if (subs.contains(str[i]) == true) {
                count = Math.max(curr, subs.size());
                subs.clear();
                curr = 0;
            } else {
                curr++;
                subs.add(str[i]);

            }
        }
        return count;
    }
}
