package ru.job4j.profession;

public class Surgeon extends Doctor {
    private String tools;

    public Surgeon(String name, String surname, String tools) {
        super(name, surname);
        this.tools = tools;
    }
}
