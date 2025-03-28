package ru.job4j.collection;

import java.util.*;
import java.util.Collections;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start += el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orbs) {
        Collections.sort(orbs, Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orbs) {
        Collections.sort(orbs, new DepDescComp());
    }
}
