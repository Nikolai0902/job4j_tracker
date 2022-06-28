package ru.job4j.tracker;

public class AddPFAction implements UserAction {
    private final Output out;

    public AddPFAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Items (Профилирование)";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new Items ====");
        int id = input.askInt("Enter the number of items: ");
        for (int i = 1; i < id + 1; i++) {
            tracker.add(new Item("N" + i));
        }
        return true;
    }
}
