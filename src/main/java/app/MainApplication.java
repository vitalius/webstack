package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import app.entity.*;
import app.repository.*;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private Environment env;
    
    private final Logger LOGGER = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    // Spring runs CommandLineRunner bean when Spring Boot App starts
    @Bean
    public CommandLineRunner demo(BookRepository bookRepository) {
        return (args) -> {
            LOGGER.info("CHECKING application.properties: " + env.getProperty("userDefined.path"));

            Book b1 = new Book("Book A", BigDecimal.valueOf(9.99), LocalDate.of(2023, 8, 31));
            Book b2 = new Book("Book B", BigDecimal.valueOf(19.99), LocalDate.of(2023, 7, 31));
            Book b3 = new Book("Book C", BigDecimal.valueOf(29.99), LocalDate.of(2023, 6, 10));
            Book b4 = new Book("Book D", BigDecimal.valueOf(39.99), LocalDate.of(2023, 5, 5));

            // save a few books, ID auto increase, expect 1, 2, 3, 4
            bookRepository.save(b1);
            bookRepository.save(b2);
            bookRepository.save(b3);
            bookRepository.save(b4);

            // find all books
            LOGGER.info("findAll(), expect 4 books");
            LOGGER.info("-------------------------------");
            for (Book book : bookRepository.findAll()) {
                LOGGER.info(book.toString());
            }
            LOGGER.info("\n");

            // find book by ID
            Optional<Book> optionalBook = bookRepository.findById(1L);
            optionalBook.ifPresent(obj -> {
                LOGGER.info("Book found with findById(1L):");
                LOGGER.info("--------------------------------");
                LOGGER.info(obj.toString());
                LOGGER.info("\n");
            });

            // find book by title
            LOGGER.info("Book found with findByTitle('Book B')");
            LOGGER.info("--------------------------------------------");
            bookRepository.findByTitle("Book C").forEach(b -> {
                LOGGER.info(b.toString());
                LOGGER.info("\n");
            });

            // find book by published date after
            LOGGER.info("Book found with findByPublishedDateAfter(), after 2023/7/1");
            LOGGER.info("--------------------------------------------");
            bookRepository.findByPublishedDateAfter(LocalDate.of(2023, 7, 1)).forEach(b -> {
                LOGGER.info(b.toString());
                LOGGER.info("\n");
            });

            // delete a book
            bookRepository.deleteById(2L);
            LOGGER.info("Book delete where ID = 2L");
            LOGGER.info("--------------------------------------------");
            // find all books
            LOGGER.info("findAll() again, expect 3 books");
            LOGGER.info("-------------------------------");
            for (Book book : bookRepository.findAll()) {
                LOGGER.info(book.toString());
            }
            LOGGER.info("\n");
        };
    }

}