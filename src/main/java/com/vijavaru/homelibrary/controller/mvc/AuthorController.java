package com.vijavaru.homelibrary.controller.mvc;

import com.vijavaru.homelibrary.entities.Author;
import com.vijavaru.homelibrary.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

// to handle HTTP requests.
@Controller
@RequestMapping("/v1/homelibrary/authors")
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
    public String getAuthorById(@PathVariable Long id, Model model) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (!author.isPresent() || author.isEmpty()) {
            model.addAttribute("errorMessage", "Author not found");
            return "error";
        }
        model.addAttribute("author", author);
        return "author";
    }

    @PostMapping
    public String addAuthor(@RequestBody Author author, Model model) {
        Author savedAuthor = authorService.createAuthor(author);
        if (savedAuthor != null) {
            return "redirect:/authors";
        } else {
            model.addAttribute("errorMessage", "Error creating author");
            return "error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }
}
