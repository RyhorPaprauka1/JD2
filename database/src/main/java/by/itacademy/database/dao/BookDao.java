package by.itacademy.database.dao;

import by.itacademy.database.entity.Book;

public class BookDao {

    private static final BookDao INSTANCE = new BookDao();

    public Book getRandomBook() {
        return Book.builder()
                .id(1L)
                .name("Азбука")
                .build();
    }

    public static BookDao getInstance() {
        return INSTANCE;
    }
}
