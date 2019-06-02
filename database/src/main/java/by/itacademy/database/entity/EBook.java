package by.itacademy.database.entity;

import by.itacademy.database.entity.enums.EFormat;
import by.itacademy.database.entity.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("EBOOK")
public class EBook extends Book {

    @Column(name = "e_format")
    @Enumerated(EnumType.STRING)
    private EFormat eFormat;

    @Builder
    public EBook(String name, Genre genre, Integer price, EFormat eFormat) {
        super(name, genre, price);
        this.eFormat = eFormat;
    }
}
