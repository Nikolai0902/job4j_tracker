package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
            if (rsl == -1) {
                throw new ElementNotFoundException("not element");
            }
        return rsl;
    }

    public static void main(String[] args) {
        String[] in = {"A", "B", "С"};
        try {
            System.out.println(indexOf(in, "D"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
