package ru.job4j.pojo;

public class Book {
    private String name;
    private int page;

    public Book(String name, int page) {
        this.name = name;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

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
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            System.out.println(pr.getName() + " - " + pr.getPage());
        }
        System.out.println("Replace 0 to 3");
        Book tmg = books[0];
        books[0] = books[3];
        books[3] = tmg;
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            System.out.println(pr.getName() + " - " + pr.getPage());
        }
        System.out.println("only Clean code");
        for (int i = 0; i < books.length; i++) {
            Book pr = books[i];
            if (pr.getName().equals("Clean code")) {
                System.out.println(pr.getName() + " - " + pr.getPage());
            }
        }
    }
}


