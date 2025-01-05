package com.vijavaru.homelibrary.controller.mvc;

import com.vijavaru.homelibrary.entities.Book;
import com.vijavaru.homelibrary.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
// to handle HTTP requests.
@Controller
@RequestMapping("/v1/homelibrary/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);
        if (!book.isPresent() || book.isEmpty()) {
            model.addAttribute("errorMessage", "Book not found");
            return "error";
        }
        model.addAttribute("book", book);
        return "book";
    }

    @PostMapping
    public String addBook(@RequestBody Book book, Model model) {
        Book savedBook = bookService.createBook(book);
        if (savedBook != null) {
            return "redirect:/books";
        } else {
            model.addAttribute("errorMessage", "Error creating book");
            return "error";
        }
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
