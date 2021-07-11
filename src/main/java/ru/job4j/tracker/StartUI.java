package ru.job4j.tracker;

import com.sun.source.util.SourcePositions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item data = new Item();
        LocalDateTime a = data.getCreated();
        System.out.println("Текущие дата и время: " + a);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = a.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
        Item dataTwo = new Item("Nikolai");
        System.out.println("Задание 9. toString");
        System.out.println(dataTwo);
    }
}
