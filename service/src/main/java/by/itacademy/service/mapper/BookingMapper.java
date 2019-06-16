package by.itacademy.service.mapper;

import by.itacademy.database.entity.Booking;
import by.itacademy.service.dto.BookingDto;
import org.mapstruct.Mapper;

@Mapper(uses = {BookMapper.class, UserMapper.class})
public interface BookingMapper {

    Booking dtoToBooking(BookingDto dto);

    BookingDto bookingToDto(Booking booking);
}
