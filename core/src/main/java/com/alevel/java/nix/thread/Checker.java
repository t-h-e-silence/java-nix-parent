package com.alevel.java.nix.thread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Scanner;

public class Checker implements Runnable{
    Scanner scanner;
    StringBuilder input;

    public Checker() {
        input=new StringBuilder();
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String text = scanner.next();
        while (!text.equals("quit")) {
            input.append(scanner.next());
        }
    }

    public StringBuilder getInput() {
        return input;
    }
}