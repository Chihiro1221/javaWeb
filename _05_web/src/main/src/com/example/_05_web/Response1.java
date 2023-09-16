package com.example._05_web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("正在重定向...");
        // 重定向设置
        // 方式1：1. 设置状态码
        resp.setStatus(302);
        // 2. 设置响应头
        resp.setHeader("Location","http://localhost:8088/_05_web/response2");
        // 方式2：
        resp.sendRedirect("http://localhost:8088/_05_web/response2");
    }
}
