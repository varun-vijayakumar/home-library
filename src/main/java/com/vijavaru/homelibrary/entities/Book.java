package com.vijavaru.homelibrary.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true)
    public String title;

    public String author;

    @NonNull
    public Language language;

    @NonNull
    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "book_genres", joinColumns = @JoinColumn(name = "book_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    public List<Genre> genre;

    public String description;

    public Book() {}

    public Book(@JsonProperty("title") @NonNull String title,
                @JsonProperty("author") @NonNull String author,
                @JsonProperty("language") @NonNull Language language,
                @JsonProperty("description") String description,
                @JsonProperty("genre") @NonNull List<Genre> genres) {
        this.title = title;
        this.language = language;
        this.genre = new ArrayList<>(genres);
        this.author = author;
        this.description = description == null ? "": description;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Language getLanguage() {
        return this.language;
    }

    public List<Genre> getGenres() {
        return Collections.unmodifiableList(this.genre);
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "name : "+ title +", language : "+language+", genre: "+genre;
    }
}
