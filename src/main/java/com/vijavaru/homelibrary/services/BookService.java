package com.vijavaru.homelibrary.services;

import com.vijavaru.homelibrary.entities.Author;
import com.vijavaru.homelibrary.entities.Book;
import com.vijavaru.homelibrary.repository.AuthorRepository;
import com.vijavaru.homelibrary.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// to handle the business logic.
@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public void updateBook(Book book) {

    }

    public void deleteBook(Long id) {
        System.out.println("DevDBG - "+id);
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookById(Long bookId) {
        //log.info("getBook");
       return bookRepository.findById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
