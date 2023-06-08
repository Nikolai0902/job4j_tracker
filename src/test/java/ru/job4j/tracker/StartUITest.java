package ru.job4j.tracker;

import org.junit.*;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.output.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Store tracker = new SqlTracker(connection);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Output output = new ConsoleOutput();
        Store tracker = new SqlTracker(connection);
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
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Store tracker = new SqlTracker(connection);
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
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        SqlTracker tracker = new SqlTracker(connection);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                ""
        ));
    }

    @Test
    public void findAllAction() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAction(out));
        actions.add(new ExitAction(out));
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                "=== Show all items ===="
                        + System.lineSeparator()
                        + item
                        + System.lineSeparator()
        ));
    }

    @Test
    public void findByNameAction() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        String name = item.getName();
        Input in = new StubInput(
                new String[]{"0", name, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                        "=== Find items by name ===="
                        + System.lineSeparator()
                        + item
                        + System.lineSeparator()
        ));
    }

    @Test
    public void findByIdAction() {
        Output out = new StubOutput();
        Store tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[]{"0", id, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                "=== Find item by id ===="
                        + System.lineSeparator()
                        + item
                        + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7", "0"}
        );
        Store tracker = new SqlTracker(connection);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI().init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                ""
                )
        );
    }
}