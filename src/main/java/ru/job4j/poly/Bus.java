package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int count) {
    count = count + 1;
    }

    @Override
    public int fillUp(int fuel) {
        int price = 0;
        price = fuel * 50;
        return price;
    }
}
