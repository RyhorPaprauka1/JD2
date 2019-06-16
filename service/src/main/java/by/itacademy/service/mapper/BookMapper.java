package by.itacademy.service.mapper;

import by.itacademy.database.entity.Book;
import by.itacademy.service.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper(uses = {AuthorMapper.class, CommentMapper.class, BookingMapper.class})
public interface BookMapper {

    Book dtoToBook(BookDto dto);

    BookDto bookToDto(Book book);
}
