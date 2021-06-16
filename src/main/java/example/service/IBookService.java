package example.service;

import example.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
}
