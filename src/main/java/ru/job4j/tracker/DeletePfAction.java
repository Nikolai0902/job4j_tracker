package ru.job4j.tracker;

public class DeletePfAction implements UserAction {
    private final Output out;

    public DeletePfAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Items (Профилирование)";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ====");
        int id = input.askInt("Enter the number of items: ");
        for (int i = 1; i < id + 1; i++) {
            if (tracker.delete(i)) {
                out.println("Заявка удалена успешно.");
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        return true;
    }
}
