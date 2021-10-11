package ru.job4j.map;

import ru.job4j.collection.Account;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = students.keySet()
                .stream()
                .filter(s -> account.equals(s.getAccount()))
                .findFirst();
        if (!rsl.isPresent()) {
            System.out.println("Element not found.");
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            rsl = students.get(s.get())
                    .stream()
                    .filter(subj -> name.equals(subj.getName()))
                    .findFirst();
        } else {
            System.out.println("Element not found.");
        }
        return rsl;
    }
}
