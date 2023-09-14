package com.study.web;

import com.study.entity.Book;
import com.study.entity.Page;
import com.study.service.impl.BookServiceImpl;
import com.study.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookServiceImpl bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Integer pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        // 不应该使用请求转发，请求转发是一次请求，并且浏览器地址没有变化，如果这时用户刷新页面，还是会保留最后一次的请求地址，那么就会重新的调用add函数
        // 注意：请求转发是自带工程名的
        // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, res);
        // 请求重定向不带工程名
        res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNumber=" + (pageNumber + 1));
    }

    protected void update(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        // 不应该使用请求转发，请求转发是一次请求，并且浏览器地址没有变化，如果这时用户刷新页面，还是会保留最后一次的请求地址，那么就会重新的调用add函数
        // 注意：请求转发是自带工程名的
        // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, res);
        // 请求重定向不带工程名
        res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNumber=" + req.getParameter(
                "pageNumber"));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        bookService.deleteBookById(id);
        res.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNumber=" + req.getParameter("pageNumber"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, res);
    }

    protected void page(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int pageNumber = WebUtils.parseInt(req.getParameter("pageNumber"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNumber, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, res);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        // 将图书信息保存到请求域中
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?pageNumber=" + req.getParameter("pageNumber")).forward(req, res);
    }

}
