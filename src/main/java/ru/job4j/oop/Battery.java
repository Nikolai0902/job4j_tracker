package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery one = new Battery(5);
        Battery second = new Battery(1);
        System.out.println("one : " + one.load + ". second : " + second.load);
        one.exchange(second);
        System.out.println("one : " + one.load + ". second : " + second.load);

    }
}
