package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepa");
        for (Object n: names) {
            System.out.println(n);
        }
    }
}
