package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(n -> n.getScore())
                .average()
                .orElse(0.0d);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(s -> new Tuple(s.getName(), s.getSubjects().stream()
                .mapToInt(n -> n.getScore())
                .average()
                .orElse(0.0d)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                .mapToInt(subject -> subject.getScore())
                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
