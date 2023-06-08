package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.output.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
