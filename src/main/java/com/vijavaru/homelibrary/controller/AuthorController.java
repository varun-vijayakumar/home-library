package com.vijavaru.homelibrary.controller;

import com.vijavaru.homelibrary.entities.Author;
import com.vijavaru.homelibrary.services.AuthorService;
import com.vijavaru.homelibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

// to handle HTTP requests.
@Controller
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String getAllAuthors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }


    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()) {
            return ResponseEntity.ok(author.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Long> addAuthor(@RequestBody Author author) {
        Optional<Long> authorId = authorService.createAuthor(author);
        if (authorId.isPresent()) {
            return ResponseEntity.ok(authorId.get());
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
