package com.study.web;

import com.study.entity.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import com.study.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();
        System.out.println("map:" + map.entrySet());
        // 1.获取请求参数
        User user = WebUtils.copyParamToBean(map, new User());
        System.out.println(user);
        String code = req.getParameter("code");
        // 2.判断验证码
        System.out.println(user);
        if (code.equalsIgnoreCase("abcde")) {
            // 3.检查用户名是否已存在
            if (userService.existsUsername(user.getUsername())) {
                System.out.println("用户名[" + user.getUsername() + "]已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                // 4.成功注册
                userService.registerUser(new User(null, user.getUsername(), user.getPassword(), user.getEmail()));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
