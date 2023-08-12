package com.study.web;

import com.study.entity.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        if (user != null) {
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        } else {
            System.out.println("登录失败");
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }
    }
}
