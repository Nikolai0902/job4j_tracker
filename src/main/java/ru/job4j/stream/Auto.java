package ru.job4j.stream;

public class Auto {
    private String mark;
    private String model;
    private int run;
    private String colour;
    private String category;
    private boolean privod;
    private String box;

    static class Builder {
        private String mark;
        private String model;
        private int run;
        private String colour;
        private String category;
        private boolean privod;
        private String box;

        Builder buildMark(String mark) {
            this.mark = mark;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildRun(Integer run) {
            this.run = run;
            return this;
        }

        Builder buildColour(String colour) {
            this.colour = colour;
            return this;
        }

        Builder buildCategory(String category) {
            this.category = category;
            return this;
        }

        Builder buildPrivod(Boolean privod) {
            this.privod = privod;
            return this;
        }

        Builder buildBox(String box) {
            this.box = box;
            return this;
        }

        Auto build() {
            Auto auto = new Auto();
            auto.mark = mark;
            auto.model = model;
            auto.run = run;
            auto.colour = colour;
            auto.category = category;
            auto.privod = privod;
            auto.box = box;
            return auto;
        }
    }

    public static void main(String[] args) {
        Auto auto = new Builder().buildMark("BMW")
                .buildModel("3 series")
                .buildRun(20000)
                .buildColour("black")
                .buildCategory("С class")
                .buildPrivod(true)
                .buildBox("automatic")
                .build();
    }
}
