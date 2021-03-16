package ru.job4j.profession;

public class Dentist extends Doctor {
    private String caries;

    public Dentist(String name, String surname, String caries) {
        super(name, surname);
        this.caries = caries;
    }
}
