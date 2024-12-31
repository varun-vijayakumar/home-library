package com.vijavaru.homelibrary.controller;

import com.vijavaru.homelibrary.entities.Author;
import com.vijavaru.homelibrary.entities.Book;
import com.vijavaru.homelibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// to handle HTTP requests.
@Controller
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllAuthors(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Long> addBook(@RequestBody Book book) {
        Optional<Long> bookId = bookService.createBook(book);
        if (bookId.isPresent()) {
            return ResponseEntity.ok(bookId.get());
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
