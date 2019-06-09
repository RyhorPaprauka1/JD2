package by.itacademy.database.util;

import by.itacademy.database.entity.AudioBook;
import by.itacademy.database.entity.Author;
import by.itacademy.database.entity.Blacklist;
import by.itacademy.database.entity.Book;
import by.itacademy.database.entity.Booking;
import by.itacademy.database.entity.Comment;
import by.itacademy.database.entity.Contacts;
import by.itacademy.database.entity.EBook;
import by.itacademy.database.entity.PrintedBook;
import by.itacademy.database.entity.User;
import by.itacademy.database.entity.enums.AudioFormat;
import by.itacademy.database.entity.enums.EFormat;
import by.itacademy.database.entity.enums.Genre;
import by.itacademy.database.entity.enums.Rights;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EntityCreator {

    private static EntityCreator INSTANCE = new EntityCreator();

    public static EntityCreator getInstance() {
        return INSTANCE;
    }

    public User createUser(String login) {
        return User.builder()
                .login(login)
                .password("pass")
                .name("имя")
                .surname("фамилия")
                .rights(Rights.LIMIT)
                .contacts(Contacts.of("почта@mail.ru", "чижовка", "+375(25)456-12-12"))
                .build();
    }

    public PrintedBook createPrintedBook(String name, Genre genre) {
        return PrintedBook.builder()
                .name(name)
                .genre(genre)
                .price(99)
                .pages(300)
                .build();
    }

    public EBook createEBook() {
        return EBook.builder()
                .name("Книга")
                .genre(Genre.CLASSIC)
                .price(99)
                .eFormat(EFormat.PDF)
                .build();
    }

    public AudioBook createAudioBook() {
        return AudioBook.builder()
                .name("Книга")
                .genre(Genre.CLASSIC)
                .price(99)
                .audioFormat(AudioFormat.M4B)
                .build();
    }

    public Author createAuthor() {
        return Author.builder()
                .name("Автор")
                .surname("Авторов")
                .build();
    }

    public Booking createBooking(User user) {
        return Booking.builder()
                .user(user)
                .isCompleted(false)
                .isProcessed(false)
                .build();
    }

    public Comment createComment(User user, Book book) {
        return Comment.builder()
                .user(user)
                .book(book)
                .text("лайк")
                .build();
    }

    public Blacklist createBlacklist(User user) {
        return Blacklist.builder()
                .id(user.getId())
                .user(user)
                .reason("ругался матом")
                .build();
    }
}
