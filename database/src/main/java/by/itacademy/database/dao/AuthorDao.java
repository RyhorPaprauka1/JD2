package by.itacademy.database.dao;

import by.itacademy.database.entity.Author;

public class AuthorDao implements BaseDao<Long, Author> {

    private static final AuthorDao INSTANCE = new AuthorDao();

    public static AuthorDao getInstance() {
        return INSTANCE;
    }
}
