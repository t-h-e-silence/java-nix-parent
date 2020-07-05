package com.alevel.java.nix.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkWithCSVTest {
    String filename = "C:/alevel-java-nix/core/src/main/java/com/alevel/java/nix/io/file.csv";
    WorkWithCSV v = new WorkWithCSV();

    @Test
    void fromCvs() throws IOException {
        ArrayList records;
        records = (ArrayList) v.fromCvs(filename);
        String actual = Arrays.deepToString(records.toArray());
        String res = "[[Заголовок1, Заголовок2, Заголовок3, Заголовок4, Заголовок5], " +
                "[значение1-1, значение1-2, значение1-3, значение1-4, значение1-5], " +
                "[значение2-1, значение2-2, значение2-3, значение2-4, значение2-5], " +
                "[значение3-1, значение3-2, значение3-3, значение3-4, значение3-5], " +
                "[значение4-1, значение4-2, значение4-3, значение4-4, значение4-5], " +
                "[значение5-1, значение5-2, значение5-3, значение5-4, значение5-5]]";
        assertEquals(res, actual);
        ArrayList res1;
        res1 = (ArrayList) v.fromCvs("");
        assertEquals(null, res1);

    }

    @Test
    void headers() throws IOException {
        ArrayList records = (ArrayList) v.fromCvs(filename);
        ArrayList<String> res = new ArrayList<>();
     String head =  "[Заголовок1, Заголовок2, Заголовок3, Заголовок4, Заголовок5]";

        res = (ArrayList<String>) v.headers(records);
        assertEquals(head, Arrays.toString(res.toArray()));
        ArrayList<String> res1 = new ArrayList<>();
        res1 = (ArrayList<String>) v.headers(null);
        assertEquals(res1, null);
    }

    @Test
    void byRowAndColl() throws IOException {
        ArrayList records = (ArrayList) v.fromCvs(filename);
       String res= v.byRowAndColl(records, 4, 3);
       String act="значение4-3";
       assertEquals(act,res);
        String res1= v.byRowAndColl(null, 4, 3);
        assertEquals(null, res1);
        String res2= v.byRowAndColl(records, 0, 3);
        assertEquals(null, res2);
        String res3= v.byRowAndColl(records, 10, 3);
        assertEquals(null, res3);
        String res4= v.byRowAndColl(records, 4, 5);
        assertEquals("значение4-5", res4);

    }

    @Test
    void byRowAndText() throws IOException {
        ArrayList records = (ArrayList) v.fromCvs(filename);
        String res= v.byRowAndText(records,2, "Заголовок5");
        String act="значение2-5";
        assertEquals(act,res);
        String res1= v.byRowAndText(records,2, "");
        assertEquals(null,res1);
        String res2= v.byRowAndText(records,9, "Заголовок5");
        assertEquals(null,res2);

    }
}