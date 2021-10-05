package ru.job4j.stremapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Al {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, -4, -5);
        List<Integer> next = list.stream().filter(n -> n > 0).collect(Collectors.toList());
        next.forEach(System.out::println);
    }
}
