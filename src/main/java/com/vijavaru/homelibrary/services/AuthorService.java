package com.vijavaru.homelibrary.services;

import com.vijavaru.homelibrary.entities.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// to handle the business logic.
@Service
@Slf4j
public class AuthorService {

    public Optional<Long> createAuthor(Author author) {
        return Optional.of(-1L);
    }

    public void updateAuthor(Author author) {

    }

    public void deleteAuthor(Long id) {
        //log.info("deleteAuthor");
    }

    public Optional<Author> getAuthorById(Long authorId) {
        //log.info("getAuthorById");
        Author author1 = new Author("John", "Doe");
        return Optional.of(author1);

    }

    public List<Author> getAllAuthors() {
        //log.info("getAllAuthors");
        Author author1 = new Author("John", "Doe");
        Author author2 = new Author("Jane", "Doe");
        return new ArrayList<>(List.of(author1, author2));
    }

}
