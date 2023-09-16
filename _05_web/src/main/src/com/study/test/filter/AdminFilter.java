package com.study.test.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("admin filter的构造方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("admin filter的初始化方法");
        System.out.println("filter-name是" + filterConfig.getFilterName());
        System.out.println("初始化参数username是" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数password是" + filterConfig.getInitParameter("password"));
        System.out.println("servlet对象是" + filterConfig.getServletContext());

    }

    /**
     * doFilter 方法会在获取资源之前执行，在此进行权限校验等
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("admin filter的过滤方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("admin filter的销毁方法");
    }
}
