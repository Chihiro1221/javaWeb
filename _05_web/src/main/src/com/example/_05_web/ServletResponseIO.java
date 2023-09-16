package com.example._05_web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletResponseIO extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(resp.getCharacterEncoding());
        // 解决中文显示异常问题
        // 方法1：
        // 1. 设置服务器编码
        resp.setCharacterEncoding("UTF-8");
        // 2. 设置浏览器编码
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        // 方法2：
        // 同时设置服务器和浏览器的编码格式
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write("response's content!!!");
        writer.write("你好啊");
    }
}
