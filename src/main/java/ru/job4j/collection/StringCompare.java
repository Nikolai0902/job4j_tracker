package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int m = Math.min(left.length(), right.length());
        for (int i = 0; i < m; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
           rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
