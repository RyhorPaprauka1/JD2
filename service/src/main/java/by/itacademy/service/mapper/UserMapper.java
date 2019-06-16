package by.itacademy.service.mapper;

import by.itacademy.database.entity.User;
import by.itacademy.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(uses = {ContactsMapper.class, BlacklistMapper.class, BookingMapper.class})
public interface UserMapper {

    User dtoToUser(UserDto dto);

    UserDto userToDto(User user);
}
