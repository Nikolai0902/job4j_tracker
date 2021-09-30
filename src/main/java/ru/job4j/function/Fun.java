package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Fun {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        int t = 0;
        for (double i = start; i < end; i++) {
            double f = func.apply(i);
            rsl.add(t, f);
            t++;
        }
        return rsl;
    }
}
