package com.kodilla.kodillawebfluxbook.controller;

import com.kodilla.kodillawebfluxbook.domain.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.Duration;

@RestController
public class BookController {

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getBooks() {

        BookDto b1 = new BookDto("Title1", "Author1", 2000);
        BookDto b2 = new BookDto("Title2", "Author2", 2001);
        BookDto b3 = new BookDto("Title3", "Author3", 2002);

        return Flux
                .just(b1, b2, b3)
                .delayElements(Duration.ofSeconds(2))
                .log();
    }
}
