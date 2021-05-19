package ru.job4j.pojo;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Nikolai Buslaev");
        student.setGroup("123");
        student.setStart(new Date());

        System.out.println(student.getFio() + " : " + student.getGroup() + " : " + student.getStart());
    }
}
