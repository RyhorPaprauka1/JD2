package by.itacademy.service.mapper;

import by.itacademy.database.entity.Author;
import by.itacademy.service.dto.AuthorDto;
import org.mapstruct.Mapper;

@Mapper(uses = {BookMapper.class})
public interface AuthorMapper {

    Author dtoToAuthor(AuthorDto dto);

    AuthorDto authorToDto(Author author);
}
