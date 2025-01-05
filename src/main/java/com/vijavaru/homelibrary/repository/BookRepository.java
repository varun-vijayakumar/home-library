package com.vijavaru.homelibrary.repository;

import com.vijavaru.homelibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
