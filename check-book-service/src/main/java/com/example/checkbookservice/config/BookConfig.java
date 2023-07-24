package com.example.checkbookservice.config;

import com.example.checkbookservice.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class BookConfig {
    @Bean
    public Function<Book, Book> updateBook() {
        return book -> Book.builder()
                .id(book.getId())
                .name(book.getName())
                .description(book.getDescription())
                .status("checked")
                .price(book.getPrice())
                .build();
    }
}
