package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double res = a.distance(b);
        double expect = 2;
        assertThat(res, closeTo(expect, 0.001));
    }

    @Test
    public void distance5() {
        Point a = new Point(0, 1);
        Point b = new Point(5, 1);
        double res = a.distance(b);
        double expect = 5;
        assertThat(res, closeTo(expect, 0.001));
    }

    @Test
    public void distance4() {
        Point a = new Point(0, 1, 1);
        Point b = new Point(0, 1,5);
        double res = a.distance3d(b);
        double expect = 4;
        assertThat(res, closeTo(expect, 0.001));
    }
}