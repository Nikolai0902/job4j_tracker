package ru.job4j.tracker;

public class Itemm {
    private String name;
    private int id;

    public Itemm() {
    }

    public Itemm(int id) {
        this.id = id;
    }

    public Itemm(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Itemm item = new Itemm();
    }
}
