package ru.job4j.profession;

public class Programmer extends Engineer {
    private Boolean java;

    public Programmer(String name, String surname, String soft, boolean learn) {
        super(name, surname, soft);
        this.java = learn;
    }
}
