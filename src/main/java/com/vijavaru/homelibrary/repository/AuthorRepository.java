package com.vijavaru.homelibrary.repository;

import com.vijavaru.homelibrary.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
