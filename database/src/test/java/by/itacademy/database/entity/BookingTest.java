package by.itacademy.database.entity;

import by.itacademy.database.util.EntityCreator;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;

import static by.itacademy.database.util.SessionManager.getSession;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class BookingTest extends EntityBaseTest {

    private static EntityCreator entityCreator = EntityCreator.getInstance();

    @Test
    public void checkSaveBooking() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        User user = entityCreator.createUser("логин");
        session.save(user);

        Booking booking = entityCreator.createBooking(user);
        Serializable id = session.save(booking);
        assertNotNull(id);
    }

    @Test
    public void checkGetBooking() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        User user = entityCreator.createUser("логин");
        Serializable userId = session.save(user);
        assertNotNull(userId);

        Booking booking = entityCreator.createBooking(user);
        Serializable id = session.save(booking);
        assertNotNull(id);

        fillBooking(session, booking);
        session.getTransaction().commit();
        session.clear();

        Booking savedBooking = session.get(Booking.class, id);
        assertNotNull(savedBooking);
        assertThat(savedBooking.getUser(), equalTo(user));
    }

    private void fillBooking(Session session, Booking booking) {
        Book book = entityCreator.createAudioBook();
        book.getBookings().add(booking);
        session.save(book);

        Book secondBook = entityCreator.createAudioBook();
        secondBook.getBookings().add(booking);
        session.save(secondBook);
    }
}