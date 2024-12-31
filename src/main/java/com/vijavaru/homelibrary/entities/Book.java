package com.vijavaru.homelibrary.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    public String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name : "+name;
    }
}
