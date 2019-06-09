package by.itacademy.database.entity;

import by.itacademy.database.BaseTest;
import by.itacademy.database.repository.BookingRepository;
import by.itacademy.database.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class BookingTest extends BaseTest {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkSaveBooking() {
        Booking booking = Booking.builder()
                .user(userRepository.findById(99L).orElse(null))
                .completed(false)
                .processed(false)
                .build();

        bookingRepository.save(booking);
        assertNotNull(bookingRepository.findById(booking.getId()));
    }

    @Test
    public void checkGetBooking() {
        Booking booking = bookingRepository.findById(99L).orElse(null);
        assertNotNull(booking);
        assertThat(booking.getUser().getLogin(), equalTo("user"));
        assertThat(booking.getBooks(), hasSize(1));
    }
}