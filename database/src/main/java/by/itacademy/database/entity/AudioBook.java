package by.itacademy.database.entity;

import by.itacademy.database.entity.enums.AudioFormat;
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
@DiscriminatorValue("AUDIOBOOK")
public class AudioBook extends Book {

    @Column(name = "audio_format")
    @Enumerated(EnumType.STRING)
    private AudioFormat audioFormat;

    @Builder
    public AudioBook(String name, Genre genre, Integer price, AudioFormat audioFormat) {
        super(name, genre, price);
        this.audioFormat = audioFormat;
    }
}
