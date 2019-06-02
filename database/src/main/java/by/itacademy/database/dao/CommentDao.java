package by.itacademy.database.dao;

import by.itacademy.database.entity.Comment;

public class CommentDao implements BaseDao<Long, Comment> {

    private static final CommentDao INSTANCE = new CommentDao();

    public static CommentDao getInstance() {
        return INSTANCE;
    }
}

