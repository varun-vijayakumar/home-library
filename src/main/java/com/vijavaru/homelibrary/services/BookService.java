package com.vijavaru.homelibrary.services;

import com.vijavaru.homelibrary.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// to handle the business logic.
@Service
@Slf4j
public class BookService {
    public Optional<Long> createBook(Book book) {
        return Optional.of(1001L);
    }

    public void updateBook(Book book) {

    }

    public void deleteBook(Long id) {
        //log.info("deleteBook");
    }

    public Optional<Book> getBookById(Long bookId) {
        //log.info("getBook");
        Book book1 = new Book("TestBook1");
        return Optional.of(book1);
    }

    public List<Book> getAllBooks() {
        //log.info("getAllBooks");
        Book book1 = new Book("TestBook1");
        Book book2 = new Book("TestBook2");
        return new ArrayList<>(List.of(book1, book2));
    }
}
