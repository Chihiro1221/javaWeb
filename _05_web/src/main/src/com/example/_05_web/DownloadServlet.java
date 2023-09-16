package com.example._05_web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 目前先指定具体的文件名
        String fileName = "1.jpg";
        // 获取上下文对象
        ServletContext servletContext = req.getServletContext();
        // 根据文件获取文件的mime类型
        String mimeType = servletContext.getMimeType("/file/" + fileName);
        System.out.println(mimeType);
        // 2. 根据该文件路径获取输入流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + fileName);
        // 3. 告诉浏览器我们返回的文件类型是什么
        resp.setContentType(mimeType);
        // 4. 告诉浏览器收到的数据是用于下载使用(使用响应头)
        // attachment 表示附件，filename表示下载到本地的文件名
        // resp.setHeader("Content-Disposition","attachment; filename=" + fileName);
        resp.setHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode("中国.jpg","UTF-8"));
        // 根据resp获取输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 5. 将输入流读取的数据拷贝到输出流
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
