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
public class BookingDto {

    private Long id;
    private UserDto user;
    private Boolean completed;
    private Boolean processed;
    private List<BookDto> books = new ArrayList<>();
}
