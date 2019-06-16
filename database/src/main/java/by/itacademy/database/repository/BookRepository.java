package by.itacademy.database.repository;

import by.itacademy.database.entity.Book;
import by.itacademy.database.entity.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book> {

    List<Book> findAllByGenre(Genre genre);
}
