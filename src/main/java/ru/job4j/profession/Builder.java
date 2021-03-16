package ru.job4j.profession;

public class Builder extends Engineer {
    private Boolean drawing;

    public Builder(String name, String surname, String soft, boolean learn) {
        super(name, surname, soft);
        this.drawing = learn;
    }
}
