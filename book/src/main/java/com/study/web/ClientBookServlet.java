package com.study.web;

import com.study.entity.Book;
import com.study.entity.Page;
import com.study.service.impl.BookServiceImpl;
import com.study.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    BookServiceImpl bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNumber, pageSize);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, res);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        StringBuilder url = new StringBuilder("client/bookServlet?action=pageByPrice");
        Page<Book> page = bookService.pageByPrice(pageNumber, pageSize, min, max);
        if (req.getParameter("min") != null) url.append("&min=").append(req.getParameter("min"));
        if (req.getParameter("max") != null) url.append("&max=").append(req.getParameter("max"));
        page.setUrl(url.toString());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, res);
    }

}
