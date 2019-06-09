package by.itacademy.database.entity.enums;

import lombok.Getter;

@Getter
public enum Genre {

    CLASSIC("Классика"),
    COMEDY("Комедия");

    private String description;

    Genre(String description) {
        this.description = description;
    }
}
