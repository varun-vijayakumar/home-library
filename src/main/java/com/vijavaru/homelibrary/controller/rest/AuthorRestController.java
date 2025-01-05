package com.vijavaru.homelibrary.controller.rest;

import com.vijavaru.homelibrary.entities.Author;
import com.vijavaru.homelibrary.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// to handle REST requests.
@RestController
@RequestMapping("/api/v1/homelibrary/authors")
public class AuthorRestController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors(Model model) {
        return authorService.getAllAuthors();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()) {
            return ResponseEntity.ok().body(author.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author savedAuthor = authorService.createAuthor(author);
        if (savedAuthor != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
