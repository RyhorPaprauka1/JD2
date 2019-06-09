package by.itacademy.database.dao;

import by.itacademy.database.entity.Book;
import by.itacademy.database.util.EntityCreator;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static by.itacademy.database.entity.enums.Genre.CLASSIC;
import static by.itacademy.database.entity.enums.Genre.COMEDY;
import static by.itacademy.database.util.SessionManager.getFactory;
import static by.itacademy.database.util.SessionManager.getSession;
import static java.util.stream.Collectors.toList;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

public class BookDaoTest {

    private static EntityCreator entityCreator = EntityCreator.getInstance();
    private static BookDao bookDao = BookDao.getInstance();

    @Before
    public void cleanTable() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        session.createQuery("delete from Book b").executeUpdate();
        session.getTransaction().commit();
    }

    @AfterClass
    public static void close() {
        getFactory().close();
    }

    @Test
    public void checkSaveGetDelete() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        Book book = entityCreator.createPrintedBook("Айвенго",CLASSIC);
        Long id = bookDao.save(book);

        assertTrue(bookDao.get(id).isPresent());

        bookDao.delete(book);
        assertFalse(bookDao.get(id).isPresent());

        session.getTransaction().commit();
    }

    @Test
    public void checkFindAll() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        fillBookTable();
        List<Book> books = bookDao.getAll();
        List<String> booksNames = books.stream()
                .map(Book::getName)
                .collect(toList());
        assertThat(books, hasSize(3));
        assertThat(booksNames, containsInAnyOrder("Философия", "Математика", "Химия"));

        session.getTransaction().commit();
    }

    @Test
    public void checkGetBooksByGenre() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        fillBookTable();
        List<Book> classicBooks = bookDao.getBooksByGenre(CLASSIC);
        assertThat(classicBooks, hasSize(2));

        session.getTransaction().commit();
    }

    private void fillBookTable() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        bookDao.save(entityCreator.createPrintedBook("Философия", CLASSIC));
        bookDao.save(entityCreator.createPrintedBook("Математика",CLASSIC));
        bookDao.save(entityCreator.createPrintedBook("Химия",COMEDY));

        session.getTransaction().commit();
    }
}