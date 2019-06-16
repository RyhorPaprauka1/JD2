package by.itacademy.service.mapper;

import by.itacademy.database.entity.Contacts;
import by.itacademy.service.dto.ContactsDto;
import org.mapstruct.Mapper;

@Mapper
public interface ContactsMapper {

    Contacts dtoToContacts(ContactsDto contactsDto);

    ContactsDto contactsToDto(Contacts contacts);
}
