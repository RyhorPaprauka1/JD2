package by.itacademy.database.dao;

import by.itacademy.database.entity.Blacklist;

public class BlackListDao implements BaseDao<Long, Blacklist> {

    private static final BlackListDao INSTANCE = new BlackListDao();

    public static BlackListDao getInstance() {
        return INSTANCE;
    }
}

