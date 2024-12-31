package com.vijavaru.homelibrary.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Author {
    public String firstName;
    public String lastName;

    public Author(@NonNull String firstName, @NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return lastName+","+firstName;
    }
}
