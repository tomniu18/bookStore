package example.service;

import example.model.Book;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceTest {
    @Test
    public void test() {
        List<Book> books = new LinkedList<>();
        books.add(new Book(1, "tom1", 1));
        books.add(new Book(2, "tom2", 2));
        books.add(new Book(2, "tom3", 3));
        books.add(new Book(2, "tom3", 4));

        // System.out.println(books.stream().collect(Collectors.groupingBy(Book::getId)));

        Object obj = books.stream().collect(Collectors.groupingBy(
                r -> r.getId() + r.getName(),
                LinkedHashMap::new,
                Collectors.toList()
        ));

        System.out.println(obj);
    }
}
