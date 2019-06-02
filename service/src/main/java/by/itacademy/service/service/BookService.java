package by.itacademy.service.service;

import by.itacademy.database.CatalogFilterDto;
import by.itacademy.database.dao.BookDao;
import by.itacademy.database.entity.Book;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BookService {

    private static final BookService INSTANCE = new BookService();

    private BookDao bookDao = BookDao.getInstance();

    public List<Book> getCatalog(CatalogFilterDto catalogFilter) {
        return bookDao.getBookCatalog(catalogFilter);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public static BookService getInstance() {
        return INSTANCE;
    }
}
