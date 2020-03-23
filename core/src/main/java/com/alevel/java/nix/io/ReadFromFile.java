package com.alevel.java.nix.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile {

    public void readFromFile(String filename, String subs) throws IOException {
        FileReader reader = new FileReader(filename);
        Files.copy(Paths.get(filename), System.out);
        Files.lines(Paths.get(filename))
                .flatMap(String::lines).
                filter(x -> x.contains(subs)).forEach(x-> System.out.println(x));
    }
    
}
