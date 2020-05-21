package com.alevel.java.nix.thread;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        Checker check= new Checker();
        Thread t=new Thread(check);
        String input="";
        System.out.println(" Start!");
        String fileName="core/src/main/java/com/alevel/java/nix/thread/input.txt";
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
            t.start();
            t.sleep(1000);
            while (t.isAlive()) {
                StringBuilder next = check.getInput();
                if (!input.equals(next.toString())) {
                        fileWriter.write(next+ "\n");
                        fileWriter.flush();
                    input = next.toString();
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
