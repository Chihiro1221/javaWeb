package com.study.web;

import com.google.gson.Gson;
import com.study.entity.Book;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 Session 中的验证码
        String token = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        // 删除 Session 中的验证码
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        Map<String, String[]> map = req.getParameterMap();
        System.out.println("map:" + map.entrySet());
        // 1.获取请求参数
        User user = WebUtils.copyParamToBean(map, new User());
        System.out.println(user);
        String code = req.getParameter("code");
        // 2.判断验证码
        System.out.println(user);
        if (token != null && code.equalsIgnoreCase(token)) {
            // 3.检查用户名是否已存在
            if (userService.existsUsername(user.getUsername())) {
                System.out.println("用户名[" + user.getUsername() + "]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                // 4.成功注册
                userService.registerUser(new User(null, user.getUsername(), user.getPassword(), user.getEmail()));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void ajaxUsernameIsExist(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String username = req.getParameter("username");
        boolean b = userService.existsUsername(username);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", b);
        Gson gson = new Gson();
        String s = gson.toJson(map);

        resp.getWriter().write(s);
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 销毁session
        req.getSession().invalidate();
        // 重定向到首页
        resp.sendRedirect(req.getContextPath());
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        if (user != null) {
            req.getSession().setAttribute("user", user);
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            System.out.println("登录失败");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
}
