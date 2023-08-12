package com.example._05_web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收到客户端传来的参数
        String username = req.getParameter("username");
        System.out.println("浏览器参数：" + username);
        // 2. 添加证明
        req.setAttribute("key", "eb21923b9da873b987e07a2fce4755de1cfffb710747c5a40c3b622f8ca6ec3f");
        // 3. 获取servlet2的地址
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        // 4. 转发到servlet2
        requestDispatcher.forward(req, resp);
        System.out.println("转发完成...");
    }
}
