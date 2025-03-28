package ru.job4j.ex;

public class Find {
    public static String get(String[] data, int i) {
        if (i <= 0 || i >= data.length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return data[i];
    }

    public static void main(String[] args) {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, 2);
        System.out.println(rsl);
    }
}
