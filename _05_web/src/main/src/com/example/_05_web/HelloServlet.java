package com.example._05_web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet {
    public static void main(String[] args) {

    }

    public HelloServlet() {
        System.out.println("构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方法");
        //1. 获取 servlet 程序别名
        System.out.println(servletConfig.getServletName());
        //2. 获取初始化参数
        System.out.println(servletConfig.getInitParameter("username"));
        System.out.println(servletConfig.getInitParameter("password"));
        //3. 获取servlet上下文
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        if(method.equals("GET")) doGet();
        else if(method.equals("POST")) doPost();
    }

    public void doGet()
    {
        System.out.println("get method has been executed...");
    }

    public void doPost()
    {
        System.out.println("post method has been executed...");
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
