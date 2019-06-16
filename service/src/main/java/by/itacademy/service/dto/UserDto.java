package by.itacademy.service.dto;

import by.itacademy.database.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private ContactsDto contacts;
    private Set<Role> roles = new HashSet<>();
    @Builder.Default
    private List<BookingDto> bookings = new ArrayList<>();
    private Set<CommentDto> comment = new HashSet<>();
    private BlacklistDto blacklist;
}
