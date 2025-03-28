package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> name = (n) -> n.getName().contains(key);
        Predicate<Person> surname = (n) -> n.getSurname().contains(key);
        Predicate<Person> phone = (n) -> n.getPhone().contains(key);
        Predicate<Person> address = (n) -> n.getAddress().contains(key);
        var combine = name.or(surname).or(phone).or(address);
        ArrayList result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}

