package by.itacademy.database.entity;

import by.itacademy.database.entity.enums.Genre;
import by.itacademy.database.util.EntityCreator;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

import static by.itacademy.database.util.SessionManager.getSession;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class BookTest extends EntityBaseTest {

    private static EntityCreator entityCreator = EntityCreator.getInstance();

    @Test
    public void checkSaveBook() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        Book book = entityCreator.createEBook();
        Serializable id = session.save(book);
        assertNotNull(id);
    }

    @Test
    public void checkGetBook() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        Book eBook = entityCreator.createEBook();
        Serializable eId = session.save(eBook);
        assertNotNull(eBook);
        Book aBook = entityCreator.createAudioBook();
        Serializable aId = session.save(aBook);
        assertNotNull(aBook);
        Book pBook = entityCreator.createPrintedBook("Книга", Genre.CLASSIC);
        Serializable pId = session.save(pBook);
        assertNotNull(pBook);

        fillBook(session, pBook);
        session.getTransaction().commit();
        session.clear();

        EBook savedEBook = session.get(EBook.class, eId);
        assertNotNull(savedEBook.getEFormat());

        AudioBook savedABook = session.get(AudioBook.class, aId);
        assertNotNull(savedABook.getAudioFormat());

        PrintedBook savedPBook = session.get(PrintedBook.class, pId);
        assertNotNull(savedPBook.getPages());
        assertThat(savedPBook.getAuthors(), hasSize(2));
        assertThat(savedPBook.getBookings(), hasSize(2));
    }

    private void fillBook(Session session, Book book) {
        Author author = entityCreator.createAuthor();
        session.save(author);
        Author secondAuthor = entityCreator.createAuthor();
        session.save(secondAuthor);

        User user = entityCreator.createUser("покупатель");
        session.save(user);

        Booking booking = entityCreator.createBooking(user);
        session.save(booking);
        Booking secondBooking = entityCreator.createBooking(user);
        session.save(secondBooking);

        book.getAuthors().add(author);
        book.getAuthors().add(secondAuthor);
        book.getBookings().add(booking);
        book.getBookings().add(secondBooking);
    }
}