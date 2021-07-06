package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] copy = new Item[size];
        int oneSize = 0;
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (name != null) {
                copy[oneSize] = name;
                oneSize++;
            }
        }
        return Arrays.copyOf(copy, oneSize);
    }

    public Item[] findByName(String key) {
        Item[] copy = new Item[size];
        int twoSize = 0;
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (name.getName().equals(key)) {
                copy[twoSize++] = name;
            }
        }

        return Arrays.copyOf(copy, twoSize);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}