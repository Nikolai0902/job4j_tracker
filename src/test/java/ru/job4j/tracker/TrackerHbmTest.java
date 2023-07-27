package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class TrackerHbmTest {

    @AfterEach
    public void cleanTableItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            var list = tracker.findAll();
            for (Item i : list) {
                tracker.delete(i.getId());
            }
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            MatcherAssert.assertThat(result.getName(), is(item.getName()));
        }
    }

    @Test
    public void whenReplaceNewItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            System.out.println(tracker.findAll());
            tracker.replace(item.getId(), new Item(item.getId(), "1"));
            System.out.println(tracker.findAll());
            MatcherAssert.assertThat(tracker.findById(item.getId()).getName(), is("1"));
        }
    }

    @Test
    public void whenDeleteNewItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            tracker.delete(item.getId());
            MatcherAssert.assertThat(tracker.findById(item.getId()), is(nullValue()));
        }
    }

    @Test
    public void whenFindAllNewItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test1");
            Item item2 = new Item("test2");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> result = tracker.findAll();
            MatcherAssert.assertThat(result.get(0).getName(), is(item1.getName()));
        }
    }

    @Test
    public void whenFindByNameNewItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test");
            Item item2 = new Item("test");
            Item item3 = new Item("test1");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> result = tracker.findByName("test");
            System.out.println(result);
            MatcherAssert.assertThat(result.size(), is(2));
            MatcherAssert.assertThat(result.get(0).getName(), is("test"));
        }
    }

    @Test
    public void whenFindByIdNewItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test");
            Item item2 = new Item("test1");
            tracker.add(item1);
            tracker.add(item2);
            Item result = tracker.findById(item2.getId());
            MatcherAssert.assertThat(result.getName(), is("test1"));
        }
    }
}
