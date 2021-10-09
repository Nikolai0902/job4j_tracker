package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public Map<String, Student> map(List<Student> students) {
        return students.stream()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                student -> student,
                                (surname1, surname2) ->  surname1
                        ));
    }

    public List<Integer> matrixToList(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of).collect(Collectors.toList());
    }
}