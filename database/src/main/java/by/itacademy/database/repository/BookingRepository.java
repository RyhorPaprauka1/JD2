package by.itacademy.database.repository;

import by.itacademy.database.entity.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {

    List<Booking> findAllByProcessedFalse();
}
