package com.study.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已保存在Session域中");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从key1中获取的数据为 " + attribute);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的超时时间为" + maxInactiveInterval);
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setMaxInactiveInterval(3);
        resp.getWriter().write("session将3秒之后销毁");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.getWriter().write("当前session已被立即销毁");
    }

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // 获取或创建session
        HttpSession session = req.getSession();
        // 查看当前session是否新创建的
        boolean isNew = session.isNew();
        // 获取当前session的id
        String id = session.getId();

        resp.getWriter().write("当前session的id是 " + id + "<br />");
        resp.getWriter().write("当前session是否为新创建的 " + isNew + "<br />");
    }
}
