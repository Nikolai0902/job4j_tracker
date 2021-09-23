package ru.job4j.collection;

import java.util.Comparator;
import static java.lang.Integer.parseInt;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] l = left.split(". ");
        String[] r = right.split(". ");
        return Integer.compare(parseInt(l[0]), parseInt(r[0]));
    }
}
