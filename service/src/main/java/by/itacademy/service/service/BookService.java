package by.itacademy.service.service;

import by.itacademy.database.entity.Book;
import by.itacademy.database.repository.BookRepository;
import by.itacademy.service.vo.CatalogValues;
import by.itacademy.service.filter.ExpressionBuilder;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.itacademy.database.entity.QBook.book;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getCatalog(CatalogValues values) {
        ExpressionBuilder eb = new ExpressionBuilder();
        eb.add(values.getName(), book.name::containsIgnoreCase);
        eb.add(values.getGenre(), book.genre::eq);
        eb.add(values.getPrice(), book.price::lt);

        Pageable pageable = PageRequest.of(values.getPage(), values.getLimit());

        return Lists.newArrayList(
                bookRepository.findAll(eb.getExpression(), pageable));
    }

    public int getPageNumber(CatalogValues dto) {
        return (int) Math.ceil(bookRepository.count() / dto.getLimit());
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
