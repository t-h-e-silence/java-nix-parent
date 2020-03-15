package com.alevel.java.nix.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CsvAggregatorTest {

    @Test
    void aggregate() {
        CsvAggregator a=new CsvAggregator();
        Object[] o=new Object[]{"string", "1", 0, 0.0, "a"};
       String join= "string, 1, 0, 0.0, a";
       assertEquals(join,a.aggregate(o));

    }
}