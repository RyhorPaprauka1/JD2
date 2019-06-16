package by.itacademy.service.dto;


import by.itacademy.database.entity.Author;
import by.itacademy.database.entity.Booking;
import by.itacademy.database.entity.Comment;
import by.itacademy.database.entity.enums.Genre;
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
public class BookDto {

    private Long id;
    private String name;
    private String about;
    private String image;
    private Genre genre;
    private Integer price;
    private List<Author> authors = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
}
