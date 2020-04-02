package com.alevel.java.nix.practice21;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Weekends {


    public ArrayList<LocalDate> weekends(LocalDate startDate, LocalDate endDate) {
        if(startDate==null||endDate==null){
            return null;
        }
        ArrayList<LocalDate> weekends = new ArrayList<>();
        while (startDate.isBefore(endDate)) {
            if (DayOfWeek.SATURDAY.equals(startDate.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(startDate.getDayOfWeek())) {
                weekends.add(startDate);
            }
            startDate = startDate.plusDays(1);
        }
        return weekends;
    }

    public static void main(String[] args) {
    }
}
