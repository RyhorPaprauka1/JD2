package by.itacademy.database.dao;

import by.itacademy.database.entity.Book;
import by.itacademy.database.entity.Booking;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Cleanup;
import org.hibernate.Session;

import java.util.List;

import static by.itacademy.database.entity.QBooking.booking;
import static by.itacademy.database.util.SessionManager.getSession;

public class BookingDao implements BaseDao<Long, Booking> {

    private static final BookingDao INSTANCE = new BookingDao();

    public static BookingDao getInstance() {
        return INSTANCE;
    }

    public List<Booking> getUnprocessedBookings() {
        @Cleanup Session session = getSession();
        return new JPAQuery<Book>(session)
                .select(booking)
                .from(booking)
                .where(booking.isProcessed.eq(false))
                .fetch();
    }
}


