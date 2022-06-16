package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Ignore
public class ValidateInputTest {

    @Ignore
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(in);
        int selected = input.askInt("1");
        assertThat(selected, is(1));
    }

    @Ignore
    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(in);
        int selected = input.askInt("1");
        assertThat(selected, is(1));
    }

    @Ignore
    @Test
    public void whenManyValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"3", "2"}
        );
        ValidateInput input = new ValidateInput(in);
        int selected = input.askInt("3");
        assertThat(selected, is(3));
        int selectedTwo = input.askInt("2");
        assertThat(selectedTwo, is(2));
    }

    @Ignore
    @Test
    public void whenMinusValidInput() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input in = new StubInput(
                new String[]{"-1", "0"}
        );
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ExitAction(out));
        new StartUI().init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu."
                        + System.lineSeparator()
                        + "0. Exit"
                        + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 0"
                        + System.lineSeparator()
                        + "Menu."
                        + System.lineSeparator()
                        + "0. Exit"
                        + System.lineSeparator()
        ));
    }
}
