package com.alevel.java.nix.DateAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ListToMap {


    public Map<LocalDate, Set<LocalTime>> toMap(Collection<LocalDateTime> ldt) {
        if (ldt == null) {
            return null;
        }

        return ldt.stream().collect(Collectors.groupingBy
                (x -> x.toLocalDate(), () -> new TreeMap<>(), mapping(x -> x.toLocalTime(), toCollection(() -> new TreeSet<>()))));
    }

}

