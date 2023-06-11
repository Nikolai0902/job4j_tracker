package ru.job4j.tracker;

import lombok.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Аннотация @Data - создаёт геттеры, сеттеры, конструктор, методы equals, hashCode, toString.
 * @NoArgsConstructor - создается конструтор без параметров.
 * @AllArgsConstructor - создает конструктор со вмести полями.
 * @EqualsAndHashCode – создаёт методы equals() и @hashCode().
 * onlyExplicitlyIncuded - явно указывает, какие поля использовать.
 * @author Buslaev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {

    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");

    private int id;

    @EqualsAndHashCode.Exclude
    private String name;

    @EqualsAndHashCode.Exclude
    private LocalDateTime created = LocalDateTime.now();

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(FORMATTER) + '}';
    }
}