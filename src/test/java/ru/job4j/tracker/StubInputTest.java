package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StubInputTest {

    @Test
    public void whenEditAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ====" + ln + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenFindIdAction() {
        Output out = new StubOutput();
        int id = 2;
        MemTracker tracker = new MemTracker();
        LocalDateTime now = LocalDateTime.now();
        Item item = new Item(1, "item", now);
        tracker.add(item);
        FindIdAction rep = new FindIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        rep.execute(input, tracker);
        when(input.askInt(any(String.class))).thenReturn(id);
        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ====" + ln + item
                + ln + "=== Find item by id ====" + ln + "Заявка с введенным id: "
                + id + " не найдена." + ln));
    }

    @Test
    public void whenDeleteAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        LocalDateTime now = LocalDateTime.now();
        Item item = new Item(1, "item", now);
        tracker.add(item);
        DeleteAction rep = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        rep.execute(input, tracker);
        when(input.askInt(any(String.class))).thenReturn(1);
        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ====" + ln + "Заявка удалена успешно."
                + ln + "=== Delete item ====" + ln + "Ошибка удаления заявки." + ln));
    }

    @Test
    public void whenFindNameAction() {
        Output out = new StubOutput();
        String name = "item";
        String nameNot = "item!";
        MemTracker tracker = new MemTracker();
        LocalDateTime now = LocalDateTime.now();
        Item item = new Item(1, name, now);
        tracker.add(item);
        FindNameAction rep = new FindNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);
        rep.execute(input, tracker);
        when(input.askStr(any(String.class))).thenReturn(nameNot);
        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln + item
                + ln + "=== Find items by name ====" + ln + "Заявки с именем: "
                + nameNot + " не найдены." + ln));
    }
}