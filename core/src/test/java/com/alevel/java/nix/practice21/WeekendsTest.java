package com.alevel.java.nix.practice21;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WeekendsTest {

    @Test
    void weekends() {
        Weekends w=new Weekends();
        LocalDate from=LocalDate.of(2020, 04, 01);
        LocalDate to=LocalDate.of(2020, 04, 15);
        ArrayList<LocalDate> list = new ArrayList<>();
        list.add(LocalDate.of(2020, 04, 04));
        list.add(LocalDate.of(2020, 04, 05));
        list.add(LocalDate.of(2020, 04, 11));
        list.add(LocalDate.of(2020, 04, 12));
        assertEquals(list, w.weekends(from, to));
    }
}