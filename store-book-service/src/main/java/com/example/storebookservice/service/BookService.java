package com.example.storebookservice.service;

import com.example.storebookservice.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import java.util.function.Consumer;

@Service
public class BookService {

    Logger logger = Logger.getLogger(BookService.class.getName());

    @Bean
    public Consumer<Book> logInputMessage() {
        return book -> logger.info("Input message processing: " + book);
    }
}
