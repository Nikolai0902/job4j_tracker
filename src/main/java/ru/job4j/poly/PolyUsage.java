package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle buss = new Buss();

        Vehicle[] vehicles = new Vehicle[]{plane, train, buss};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
