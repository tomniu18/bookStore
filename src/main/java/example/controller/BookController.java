package example.controller;

import example.model.Book;
import example.service.IBookService;
//import hello.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/books")
    public List<Book> getBooks() {
//        Greeter greeter = new Greeter();
        logger.debug("Debug getBooks" + new Date().toString());
        logger.info("Info getBooks"  + new Date().toString());
//        logger.info(greeter.sayHello());
        List<Book> cities = bookService.findAll();

        return cities;
    }
}
