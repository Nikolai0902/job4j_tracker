package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("A", "a", 1, 1)));
        Profiles one = new Profiles();
        List<Address> result = one.collect(profiles);
        List<Address> expected = List.of(
                new Address("A", "a", 1, 1)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void collectSort() {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("C", "a", 1, 1)));
        profiles.add(new Profile(new Address("B", "a", 2, 2)));
        profiles.add(new Profile(new Address("A", "a", 1, 1)));
        profiles.add(new Profile(new Address("A", "a", 1, 1)));
        Profiles one = new Profiles();
        List<Address> result = one.collect(profiles);
        List<Address> expected = List.of(
                new Address("A", "a", 1, 1),
                new Address("B", "a", 2, 2),
                new Address("C", "a", 1, 1)
        );
        assertThat(result, is(expected));
    }
}