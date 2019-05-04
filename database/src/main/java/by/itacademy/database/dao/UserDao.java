package by.itacademy.database.dao;

import by.itacademy.database.entity.User;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    public User getDefaultUser() {
        return User.builder()
                .id(1L)
                .name("Ivan")
                .build();
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
