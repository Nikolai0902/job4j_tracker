package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Fun function = new Fun();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenKvFunctionThenKvResults() {
        Fun function = new Fun();
        List<Double> result = function.diapason(2, 5, x -> x * x);
        List<Double> expected = Arrays.asList(4D, 9D, 16D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPokFunctionThenPokResults() {
        Fun function = new Fun();
        List<Double> result = function.diapason(11, 15, x -> x * 10);
        List<Double> expected = Arrays.asList(110D, 120D, 130D, 140D);
        assertThat(result, is(expected));
    }
}