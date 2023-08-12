package com.study.service.impl;

import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImpl;
import com.study.entity.User;
import com.study.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(String username, String passwordd) {
        return userDao.queryUserByUsernameAndPassword(username, passwordd);
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
