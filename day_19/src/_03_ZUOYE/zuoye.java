package _03_ZUOYE;

import java.util.HashSet;

public class zuoye {
    public static void main(String[] args) {
        HashSet<Book> books = new HashSet<>();
        books.add(new Book("毛选",9.99));
        books.add(new Book("ad",123.2));
        books.add(new Book("adz",123.2));
        books.add(new Book("ad",123.2));
        System.out.println(books);
    }
}
