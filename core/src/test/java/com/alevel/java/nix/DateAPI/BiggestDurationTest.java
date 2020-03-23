package com.alevel.java.nix.DateAPI;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiggestDurationTest {

    @Test
    void biggestDuration() {
        LocalDateTime now = LocalDateTime.now();
        List<LocalDateTime> list = Arrays.asList(
                now,
                now.minusHours(1),
                now.plusHours(1),
                now.minusDays(1),
                now.plusDays(1),
                now.plusHours(25),
                now.plusDays(2)
        );
        assertEquals(72, new BiggestDuration().biggestDuration(list).toHours());
        List<LocalDateTime> list1=new ArrayList<>();
        assertEquals(null, new BiggestDuration().biggestDuration(list1));
    }

}