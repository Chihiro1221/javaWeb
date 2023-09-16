package com.study.test;

import com.sun.net.httpserver.HttpPrincipal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        if (token != null && token.equalsIgnoreCase(req.getParameter("code"))) {
            String username = req.getParameter("username");
            System.out.println(username + "已保存到数据库");
            resp.sendRedirect(req.getContextPath() + "/register_success.html");
        } else {
            System.out.println("请勿重复提交");
        }

    }
}
