package by.itacademy.database.repository;

import by.itacademy.database.BaseTest;
import by.itacademy.database.entity.Book;
import by.itacademy.database.entity.enums.Genre;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class BookRepositoryTest extends BaseTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void checkFindAllByGenre() {
        List<Book> books = bookRepository.findAllByGenre(Genre.CLASSIC);
        assertThat(books, hasSize(2));
    }
}