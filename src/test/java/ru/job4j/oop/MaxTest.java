package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenMax6() {
        int result = Max.max(1, 2, 6);
        assertThat(result, is(6));
    }

    @Test
    public void whenMax7() {
        int result = Max.max(3, 2, 1, 7);
        assertThat(result, is(7));
    }

    @Test
    public void whenMax4() {
        int result = Max.max(1, 4);
        assertThat(result, is(4));
    }
}