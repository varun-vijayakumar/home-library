package com.vijavaru.homelibrary.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Genre {
    FICTION,
    AUTOBIOGRAPHY,
    INVESTING,
    ADVENTURE,
    CLASSICS,
    COMIC_GRAPHIC_NOVEL,
    CONTEMPORARY,
    DYSTOPIAN,
    FANTASY,
    HISTORICAL_FICTION,
    HORROR,
    LITERARY_FICTION,
    MYSTERY,
    ROMANCE,
    SCIENCE_FICTION,
    THRILLER_SUSPENSE,
    WESTERN,
    BIOGRAPHY,
    ESSAY,
    MEMOIR,
    SELF_HELP,
    TRUE_CRIME,
    HISTORY,
    SCIENCE,
    TRAVEL,
    PHILOSOPHY,
    CHILDRENS,
    PICTURE_BOOKS,
    EARLY_READERS,
    MIDDLE_GRADE,
    YOUNG_ADULT,
    POETRY,
    DRAMA,
    HUMOR,
    RELIGIOUS_SPIRITUAL,
    EDUCATIONAL_ACADEMIC;

    /**
     * to accept user input such as "Humor", "humor"
     * @param key
     * @return
     */
    @JsonCreator
    public static Genre fromString(String key) {
        return  key == null ? null : Genre.valueOf(key.toUpperCase());
    }
}
