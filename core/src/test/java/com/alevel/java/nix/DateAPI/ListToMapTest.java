package com.alevel.java.nix.DateAPI;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ListToMapTest {

    @Test
    void toMap() {
        LocalDateTime moment = LocalDateTime.of(1999, 12, 4, 14, 55, 00);
        List<LocalDateTime> ldt = Arrays.asList(moment,
                moment.minusHours(1),
                moment.plusHours(1),
                moment.minusDays(1),
                moment.plusDays(1),
                moment.plusHours(25),
                moment.plusDays(2)
        );
        var byDate = new ListToMap().toMap(ldt);
        String res = "{1999-12-03=[14:55], 1999-12-04=[13:55, 14:55, 15:55], 1999-12-05=[14:55, 15:55], 1999-12-06=[14:55]}";
        assertEquals(res, String.valueOf(byDate));
        List<LocalDateTime> l = new ArrayList<>();

        assertEquals("{}", String.valueOf(new ListToMap().toMap(l)));
    }
}