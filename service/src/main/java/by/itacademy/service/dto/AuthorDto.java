package by.itacademy.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private Long id;
    private String name;
    private String surname;
    private String bio;
    private List<BookDto> books = new ArrayList<>();
}
