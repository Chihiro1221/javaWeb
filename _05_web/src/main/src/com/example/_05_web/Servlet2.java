package com.example._05_web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收到客户端传来的参数
        String username = req.getParameter("username");
        System.out.println("servlet2 浏览器参数：" + username);
        // 2. 检查是否有证明
        Object key = req.getAttribute("key");
        System.out.println("来自servlet1的证明：" + key);
        // 3. 进行处理
        System.out.println("Servlet2 处理程序");
    }
}
