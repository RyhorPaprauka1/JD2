package by.itacademy.database.entity;

import by.itacademy.database.BaseTest;
import by.itacademy.database.entity.enums.AudioFormat;
import by.itacademy.database.entity.enums.Genre;
import by.itacademy.database.repository.BookRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;

public class BookTest extends BaseTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void checkSaveBook() {
        Book book = AudioBook.builder()
                .name("JAVA")
                .genre(Genre.CLASSIC)
                .price(50)
                .audioFormat(AudioFormat.M4B)
                .build();

        bookRepository.save(book);
        assertNotNull(bookRepository.findById(book.getId()));
    }

    @Test
    public void checkGetBook() {
        Book book = bookRepository.findById(98L).orElse(null);
        assertNotNull(book);
        assertThat(book.getName(), equalTo("ФИЗИКА"));
        assertThat(book.getAuthors(), hasSize(2));
        assertThat(book.getBookings(), hasSize(1));
    }
}