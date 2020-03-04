package com.alevel.java.nix.oop.task2;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        State s = null;
        Scanner scan = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.println("Menu: " + "\n1. Water" + "\n2. Iron" + "\n3.Oxygen");
            choice = scan.next();
            switch (choice) {
                case "1": {
                    Water w = new Water();
                    System.out.println("Enter temperature for water");
                    double temp = scan.nextDouble();
                    s = w.heatUp(temp);
                    System.out.println(String.valueOf(s));
                    break;
                }
                case "2": {
                    Iron i = new Iron();
                    System.out.println("Enter temperature for iron");
                    double temp = scan.nextDouble();
                    s = i.heatUp(temp);
                    System.out.println(String.valueOf(s));
                    break;
                }
                case "3": {
                    Oxygen o = new Oxygen();
                    System.out.println("Enter temperature for oxygen");
                    double temp = scan.nextDouble();
                    s = o.heatUp(temp);
                    System.out.println(String.valueOf(s));
                    break;
                }
            }
            if (s == null) {
                break;
            }
        }
    }
}
