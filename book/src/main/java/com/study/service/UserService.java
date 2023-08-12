package com.study.service;

import com.study.entity.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    void registerUser(User user);

    /**
     * 登录
     * @param password
     * @param username
     * @return 如果是null表示登录失败，否则就是成功
     */
    User login(String username,String password);

    /**
     * 查询用户名是否已存在
     * @param username
     * @return true表示已存在，否则反之
     */
    boolean existsUsername(String username);


}
