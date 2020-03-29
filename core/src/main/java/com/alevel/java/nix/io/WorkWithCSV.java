package com.alevel.java.nix.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WorkWithCSV {
    private static final String COMMA_DELIMITER = ",";

    public List fromCvs(String filename) throws IOException {
        if (filename == null || filename == "") {
            return null;
        }
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }

    public Collection<String> headers(List<List<String>> records) {
        if (records == null) {
            return null;
        }
        List<String> headers = new ArrayList<>();
        for (int i = 0; i < records.get(0).size(); i++) {
            headers.add(records.get(0).get(i));
        }
        return headers;
    }

    public String byRowAndColl(List<List<String>> records, int row, int coll) {
        if (records == null || row <= 0 || coll < 0 || row > records.size() || coll > records.get(row).size()) {
            return null;
        }
        return records.get(row).get(coll - 1);
    }

    public String byRowAndText(List<List<String>> records, int row, String text) {
        if (records == null || text == null || text == " " || row < 0 || row > records.size()) {
            return null;
        }
        String str = null;
        ArrayList headers = (ArrayList) headers(records);
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).equals(text)) {
                str = records.get(row).get(i);
                break;
            }
        }
        return str;
    }
}
