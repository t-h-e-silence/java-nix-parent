package com.alevel.java.nix.basicshomework;

public class Longnums {
    long number;

    Longnums(long number) {
        this.number=number;
    }

    Longnums() {
        this.number=0;
    }

    public int numsOfBits() {
        String n= Long.toBinaryString(number);
        System.out.println(n + " "+ number);
        int count=0;
        while(number!=0) {
            count+=number&1;
            number= number>>>1;
        }
        System.out.println("Количество единичных бит "+ count);
        return count;
    }
}
