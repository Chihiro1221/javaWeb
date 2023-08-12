package com.study.test;

import com.study.dao.impl.UserDaoImpl;
import com.study.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        User admin = userDao.queryUserByUsername("admin");
        if (admin != null) System.out.println("用户名已存在");
        else System.out.println("用户名不存在");
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User admin = userDao.queryUserByUsernameAndPassword("admin", "youzhi..");
        if (admin != null) System.out.println("登录成功");
        else System.out.println("用户名或密码错误");
    }

    @Test
    public void saveUser() {
        User user = new User(null, "haonan", "youzhi..", "2213595911@qq.com");
        if (userDao.saveUser(user) != -1) {
            System.out.println("保存成功");
        } else {
            System.out.println("保存失败");
        }
    }
}