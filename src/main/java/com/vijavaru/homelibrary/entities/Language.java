package com.vijavaru.homelibrary.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Language {
    ENGLISH,
    MALAYALAM;

    @JsonCreator
    public static Language fromString(String key) {
        return key == null ? null : Language.valueOf(key.toUpperCase());
    }
}
