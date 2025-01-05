package com.vijavaru.homelibrary.controller.rest;

import com.vijavaru.homelibrary.entities.Book;
import com.vijavaru.homelibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// to handle REST requests.
@RestController
@RequestMapping("/api/v1/homelibrary/books")
public class BookRestController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(Model model) {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok().body(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Long> addBook(@RequestBody Book book) {
        Book savedBook = bookService.createBook(book);
        if (savedBook != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(book.getId());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
