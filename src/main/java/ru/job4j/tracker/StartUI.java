package ru.job4j.tracker;

import java.util.List;

public class StartUI {

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                System.out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            UserAction action = actions.get(i);
            System.out.println(i + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(
                new ConsoleInput()
        );
        Output output = new ConsoleOutput();
        try (SqlTracker tracker = new SqlTracker()) {
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new ShowAction(output),
                    new EditAction(output),
                    new DeleteAction(output),
                    new FindIdAction(output),
                    new FindNameAction(output),
                    new ExitAction(output),
                    new AddPFAction(output),
                    new DeletePfAction(output)
            );
            new StartUI().init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
