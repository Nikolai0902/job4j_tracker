package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String voice = "Неизвестное слово." + eng;
        return voice;
    }

    public static void main(String[] args) {
        DummyDic book = new DummyDic();
        String say = book.engToRus("one");
        System.out.println(say);
    }
}

