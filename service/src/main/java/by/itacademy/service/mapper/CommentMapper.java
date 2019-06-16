package by.itacademy.service.mapper;

import by.itacademy.database.entity.Comment;
import by.itacademy.service.dto.CommentDto;
import org.mapstruct.Mapper;

@Mapper(uses = {UserMapper.class, BookMapper.class})
public interface CommentMapper {

    Comment dtoToComment(CommentDto dto);

    CommentDto commentToDto(Comment comment);
}
