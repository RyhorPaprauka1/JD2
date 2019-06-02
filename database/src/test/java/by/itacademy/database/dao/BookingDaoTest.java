package by.itacademy.database.dao;

import by.itacademy.database.entity.Booking;
import by.itacademy.database.entity.User;
import by.itacademy.database.util.EntityCreator;
import lombok.Cleanup;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static by.itacademy.database.util.SessionManager.getFactory;
import static by.itacademy.database.util.SessionManager.getSession;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class BookingDaoTest {

    private static EntityCreator entityCreator = EntityCreator.getInstance();
    private static BookingDao bookingDao = BookingDao.getInstance();
    private static UserDao userDao = UserDao.getInstance();

    @Before
    public void cleanTable() {
        @Cleanup Session session = getSession();
        session.beginTransaction();
        session.createQuery("delete from User u").executeUpdate();
        session.createQuery("delete from Booking bk").executeUpdate();
        session.getTransaction().commit();
    }

    @AfterClass
    public static void close() {
        getFactory().close();
    }

    @Test
    public void checkGetUnprocessedBookings() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        fillBookingTable();
        List<Booking>unprocessedBookings = bookingDao.getUnprocessedBookings();
        assertThat(unprocessedBookings, hasSize(2));

        session.getTransaction().commit();
    }

    private void fillBookingTable() {
        @Cleanup Session session = getSession();
        session.beginTransaction();

        User user = entityCreator.createUser("узер");
        userDao.save(user);
        bookingDao.save(entityCreator.createBooking(user));
        bookingDao.save(entityCreator.createBooking(user));

        Booking booking = entityCreator.createBooking(user);
        booking.setIsProcessed(true);
        bookingDao.save(booking);

        session.getTransaction().commit();
    }

}