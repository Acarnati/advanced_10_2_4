package com.example.creationbookservice.service;

import com.example.creationbookservice.model.Book;
import com.example.creationbookservice.util.BookGenerator;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.logging.Logger;

@Service
public class BookService {
    private final Source source;
    private final BookGenerator bookGenerator;
    private static final Logger logger = Logger.getLogger(BookService.class.getName());

    public BookService(Source source, BookGenerator bookGenerator) {
        this.source = source;
        this.bookGenerator = bookGenerator;
    }

    public Consumer<Book> sendMessage() {
        return book -> {
            source.output().send(MessageBuilder.withPayload(book).build());
            logger.info("Sent message with book: " + book.toString());
        };
    }

    @Scheduled(fixedRate = 10000)
    private void generateAndSendBook() {
        Book book = bookGenerator.createNewBook();
        sendMessage().accept(book);
    }
}
