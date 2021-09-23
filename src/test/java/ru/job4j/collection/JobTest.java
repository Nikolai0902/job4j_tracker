package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorAcsByName() {
        Comparator<Job> cmp = new JobAcsByName();
        int rsl = cmp.compare(
                new Job("P", 0),
                new Job("N", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("P", 0),
                new Job("N", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorAscByPri() {
        Comparator<Job> cmp = new JobAcsByPri();
        int rsl = cmp.compare(
                new Job("N", 0),
                new Job("N", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDescByPri() {
        Comparator<Job> cmp = new JobDescByPri();
        int rsl = cmp.compare(
                new Job("N", 0),
                new Job("N", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority1() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPri());
        int rsl = cmp.compare(
                new Job("N", 1),
                new Job("N", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority2() {
        Comparator<Job> cmp = new JobAcsByName().thenComparing(new JobAcsByPri());
        int rsl = cmp.compare(
                new Job("N", 2),
                new Job("N", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByProrityAndName1() {
        Comparator<Job> cmp = new JobDescByPri().thenComparing(new JobDescByName());
        int rsl = cmp.compare(
                new Job("P", 1),
                new Job("N", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByProrityAndName2() {
        Comparator<Job> cmp = new JobAcsByPri().thenComparing(new JobAcsByName());
        int rsl = cmp.compare(
                new Job("P", 1),
                new Job("N", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}