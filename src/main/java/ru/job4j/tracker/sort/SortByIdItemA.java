package ru.job4j.tracker.sort;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortByIdItemA implements Comparator<Item> {

    @Override
    public int compare(Item one, Item two) {
        return one.getName().compareTo(two.getName());
    }
}
