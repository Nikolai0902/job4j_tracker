package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.output.Input;
import ru.job4j.tracker.input.output.Output;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
