package com.alevel.java.nix.DateAPI;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.*;

public class BiggestDuration {
    public Duration biggestDuration(List<LocalDateTime> list) {

        if (list.size() == 0 || list == null) {
            return null;
        }

        Duration duration = Duration.ofDays(0);
        for (int j = 0; j < list.size(); j++) {
            LocalDateTime from = list.get(j);
            for (int i = 1; i < list.size(); i++) {
                LocalDateTime to = list.get(i);
                Duration curduration = Duration.between(from, to);
                if (curduration.toMillis() > duration.toMillis()) {
                    duration = curduration;
                }
            }
        }
        return duration;
    }

}


