package com.example._05_web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init(); // 必须先调用，否则 ServletConfig 对象将无法正常初始化
        // 1. 获取 web.xml 中定义的上下文参数
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        System.out.println("获取到的参数是：" + username + "->" + password);
        // 2. 获取工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        // 3. 获取服务器上真实运行的地址
        String realPath = servletContext.getRealPath("/");
        System.out.println(realPath);
        // 4. 存取数据
        servletContext.setAttribute("username","whn");
        System.out.println(servletContext.getAttribute("username"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        System.out.println("doGet in HelloServlet2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost in HelloServlet2");
    }
}
