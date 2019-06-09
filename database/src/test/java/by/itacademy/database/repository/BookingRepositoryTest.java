package by.itacademy.database.repository;

import by.itacademy.database.BaseTest;
import by.itacademy.database.entity.Booking;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;

public class BookingRepositoryTest extends BaseTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void checkGetAllByIsProcessedFalse() {
        List<Booking> bookings = bookingRepository.findAllByProcessedFalse();
        Assert.assertThat(bookings, hasSize(2));
    }
}