package by.itacademy.service.mapper;

import by.itacademy.database.entity.Blacklist;
import by.itacademy.service.dto.BlacklistDto;
import org.mapstruct.Mapper;

@Mapper(uses = {UserMapper.class})
public interface BlacklistMapper {

    Blacklist dtoToBlacklist(BlacklistDto dto);

    BlacklistDto blacklistToDto(Blacklist blacklist);
}
