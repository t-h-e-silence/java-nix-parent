package com.alevel.java.nix.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CopyDirectoryTest {

    @Test
    void copyDirectory() throws IOException {
        CopyDirectory d=new CopyDirectory();
        File sourceLocation=new File("C://alevel-java-nix//core//src//main//java//com//alevel//java//nix//forCopy");
        File targetLocation=new File("C://alevel-java-nix//core//src//main//java//com//alevel//java//nix//copyOfCatalog");
        assertTrue(!targetLocation.exists());
        d.copyDirectory(sourceLocation, targetLocation);
        assertTrue(targetLocation.exists());
        assertEquals(
                Files.readAllLines(Paths.get("C:\\alevel-java-nix\\core\\src\\main\\java\\com\\alevel" +
                        "\\java\\nix\\forCopy\\PackageforCopy2\\0\\forCopy3")),
                Files.readAllLines(Paths.get("C:\\alevel-java-nix\\core\\src\\main\\java\\com\\alevel" +
                        "\\java\\nix\\copyOfCatalog\\PackageforCopy2\\0\\forCopy3")));

    }
}