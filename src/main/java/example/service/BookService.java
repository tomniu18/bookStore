package example.service;

import example.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements IBookService {
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "book1", 1));
        books.add(new Book(2, "book2", 2));
        books.add(new Book(3, "book3", 3));
        return books;
    }
}
