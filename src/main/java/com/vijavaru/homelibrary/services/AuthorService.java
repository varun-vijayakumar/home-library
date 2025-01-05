package com.vijavaru.homelibrary.services;

import com.vijavaru.homelibrary.entities.Author;
import com.vijavaru.homelibrary.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// to handle the business logic.
@Service
@Slf4j
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void updateAuthor(Author author) {

    }

    public void deleteAuthor(Long id) {
        //log.info("deleteAuthor");
        authorRepository.deleteById(id);
    }

    public Optional<Author> getAuthorById(Long authorId) {
        return authorRepository.findById(authorId);

    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

}
