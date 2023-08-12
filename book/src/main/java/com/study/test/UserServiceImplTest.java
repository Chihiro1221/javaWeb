package com.study.test;

import com.study.entity.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "zs", "123456", "zs@qq.com"));
        userService.registerUser(new User(null, "ls", "123456", "ls@qq.com"));
    }

    @Test
    public void login() {
        User user = userService.login("admin", "youzhi..");
        if (user != null) System.out.println("登录成功！");
        else System.out.println("用户名或密码错误");
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin")) System.out.println("用户名已存在");
        else System.out.println("用户名不存在");
    }
}