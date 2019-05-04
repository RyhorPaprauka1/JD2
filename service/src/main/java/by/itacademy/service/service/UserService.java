package by.itacademy.service.service;

import by.itacademy.database.dao.UserDao;
import by.itacademy.database.entity.User;

public class UserService {

    private static final UserService INSTANCE = new UserService();
    private final UserDao userDao = UserDao.getInstance();

    public User getDefaultUser() {
        return userDao.getDefaultUser();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
