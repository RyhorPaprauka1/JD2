package by.itacademy.database.entity;

import by.itacademy.database.entity.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("PRINTEDBOOK")
public class PrintedBook extends Book {

    @Column(name = "pages")
    private Integer pages;

    @Builder
    public PrintedBook(String name, Genre genre, Integer price, Integer pages) {
        super(name, genre, price);
        this.pages = pages;
    }
}
