package by.itacademy.database.dao;

import by.itacademy.database.CatalogFilterDto;
import by.itacademy.database.entity.Book;
import by.itacademy.database.entity.enums.Genre;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Cleanup;
import org.hibernate.Session;

import java.util.List;

import static by.itacademy.database.entity.QBook.book;
import static by.itacademy.database.util.SessionManager.getSession;

public class BookDao implements BaseDao<Long, Book> {

    private static final BookDao INSTANCE = new BookDao();

    public static BookDao getInstance() {
        return INSTANCE;
    }

    public List<Book> getBooksByGenre(Genre genre) {
        @Cleanup Session session = getSession();
        return new JPAQuery<Book>(session)
                .select(book)
                .from(book)
                .where(book.genre.eq(genre))
                .fetch();
    }

    public List<Book> getBookCatalog(CatalogFilterDto catalogFilter) {
        @Cleanup Session session = getSession();
        JPAQuery<Book> query = new JPAQuery<>(session);
        JPAQuery<Book> catalog = query
                .select(book)
                .from(book);
        if (catalogFilter.getName() != null) {
            catalog.where(book.name.eq(catalogFilter.getName()));
        }
        if (catalogFilter.getGenre() != null) {
            catalog.where(book.genre.eq(catalogFilter.getGenre()));
        }
        if (catalogFilter.getMaxPrice() != null) {
            catalog.where(book.price.lt(catalogFilter.getMaxPrice()));
        }
        catalog.limit(catalogFilter.getLimit());
        catalog.offset(catalogFilter.getOffset());
        return catalog.fetch();
    }
}
