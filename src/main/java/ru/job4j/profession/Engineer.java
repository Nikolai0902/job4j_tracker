package ru.job4j.profession;

public class Engineer extends Profession {
    public String soft;

    public Engineer(String name, String surname, String soft) {
        super(name, surname);
        this.soft = soft;
    }
}
