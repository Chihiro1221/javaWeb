package com.study.dao;

import com.study.entity.User;

public interface UserDao {
    /**
     * 根据用户名查询用户
     * @param username
     * @return 返回null表示没有该用户，否则就是存在该用户
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名与密码查询用户是否存在
     * @param username
     * @param password
     * @return 返回null表示不存在该用户，否则就是存在该用户
     */
    User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户到数据库
     * @param user
     * @return -1表示保存失败，否则成功
     */
    int saveUser(User user);

}
