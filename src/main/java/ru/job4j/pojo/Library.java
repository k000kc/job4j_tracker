package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 464);
        Book headFirstJava = new Book("Head First Java", 720);
        Book completeGuideJava = new Book("Complete Guide Java", 1344);
        Book philosophyJava = new Book("philosophy Java", 1200);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = headFirstJava;
        books[2] = completeGuideJava;
        books[3] = philosophyJava;
        for (Book book : books) {
            System.out.println("В книге: " + book.getName()
                    + " - " + book.getCount() + "стр.");
        }
        System.out.println("Поменяли 1 и 4 книги местами");
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book book : books) {
            System.out.println("В книге: " + book.getName()
                    + " - " + book.getCount() + "стр.");
        }
        System.out.println("Поиск книги Clean Code");
        for (Book book : books) {
            if (book.getName().equals("Clean Code")) {
                System.out.println("В книге: " + book.getName()
                        + " - " + book.getCount() + "стр.");
                break;
            }
        }
    }
}
