package by.itacademy.service.service;

import by.itacademy.database.dao.BookDao;
import by.itacademy.database.entity.Book;

public class BookService {

    private static final BookService INSTANCE = new BookService();
    private final BookDao bookDao = BookDao.getInstance();

    public Book getRandomBook() {
        return bookDao.getRandomBook();
    }

    public static BookService getInstance() {
        return INSTANCE;
    }
}
