package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Store tracker = new SqlTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Output output = new ConsoleOutput();
        Store tracker = new SqlTracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String id = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", id, replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Store tracker = new SqlTracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        SqlTracker tracker = new SqlTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu."
                        + System.lineSeparator()
                        + "0. Exit"
                        + System.lineSeparator()
        ));
    }

    @Test
    public void findAllAction() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu."
                        + System.lineSeparator()
                        + "0. Show all items"
                        + System.lineSeparator()
                        + "1. Exit"
                        + System.lineSeparator()
                        + "=== Show all items ===="
                        + System.lineSeparator()
                        + item
                        + System.lineSeparator()
                        + "Menu."
                        + System.lineSeparator()
                        + "0. Show all items"
                        + System.lineSeparator()
                        + "1. Exit"
                        + System.lineSeparator()
        ));
    }

    @Test
    public void findByNameAction() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = tracker.add(new Item("item"));
        String name = item.getName();
        Input in = new StubInput(
                new String[]{"0", name, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu."
                        + System.lineSeparator()
                        + "0. Find items by name"
                        + System.lineSeparator()
                        + "1. Exit"
                        + System.lineSeparator()
                        + "=== Find items by name ===="
                        + System.lineSeparator()
                        + item
                        + System.lineSeparator()
                        + "Menu."
                        + System.lineSeparator()
                        + "0. Find items by name"
                        + System.lineSeparator()
                        + "1. Exit"
                        + System.lineSeparator()
        ));
    }

    @Test
    public void findByIdAction() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker();
        Item item = tracker.add(new Item("item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu."
                        + System.lineSeparator()
                        + "0. Find item by id"
                        + System.lineSeparator()
                        + "1. Exit"
                        + System.lineSeparator()
                        + "=== Find item by id ===="
                        + System.lineSeparator()
                        + item
                        + System.lineSeparator()
                        + "Menu."
                        + System.lineSeparator()
                        + "0. Find item by id"
                        + System.lineSeparator()
                        + "1. Exit"
                        + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7", "0"}
        );
        Store tracker = new SqlTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}