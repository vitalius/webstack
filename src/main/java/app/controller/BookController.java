package app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.tags.Tag;

import app.entity.*;
import app.repository.*;

@RestController
public class BookController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookRepository bookRepository;

    @Tag(name = "get", description = "GET methods of Books")
    @GetMapping("/books")
    public List<Book> findAllEmployees() {
        return bookRepository.findAll();
    }

    @Tag(name = "get", description = "GET methods of a book")
    @GetMapping("/book/{bookId}")
    public Book getBook(@PathVariable long bookId) {

        LOGGER.info("Info Book ID requested : {}", bookId);
        LOGGER.warn("Warn Book ID requested : {}", bookId);
        LOGGER.debug("Debug Book ID requested : {}", bookId);
        LOGGER.error("Error Book ID requested : {}", bookId);

        Book book = bookRepository.findById(bookId).orElseThrow(
            () -> new RuntimeException("Book id not found - " + bookId));

        return book;
    }
}
