package ru.job4j.tracker.input.output;

public class ConsoleOutput implements Output {

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
