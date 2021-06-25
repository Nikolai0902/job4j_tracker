package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("Clean code", 20);
        Book two = new Book("White", 10);
        Book three = new Book("Black", 5);
        Book four = new Book("Green", 2);
        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = four;
        for (Book pr : books) {
            System.out.println(pr.getName() + " - " + pr.getPage());
        }
        System.out.println("Replace 0 to 3");
        Book tmg = books[0];
        books[0] = books[3];
        books[3] = tmg;
        for (Book pr : books) {
            System.out.println(pr.getName() + " - " + pr.getPage());
        }
        System.out.println("only Clean code");
        for (Book pr : books) {
            if ("Clean code".equals(pr.getName())) {
                System.out.println(pr.getName() + " - " + pr.getPage());
            }
        }
    }
}


