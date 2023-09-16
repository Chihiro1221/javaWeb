package com.study.web;

import com.google.gson.Gson;
import com.study.entity.Book;
import com.study.entity.Cart;
import com.study.entity.CartItem;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;
import com.study.utils.WebUtils;
import org.omg.CORBA.OBJ_ADAPTER;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        if (cart != null) {
            cart.updateItemCount(id, count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
        }
        System.out.println(cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), book.getPrice(), 1, book.getPrice());
        // 将最后一次添加到购物车的商品保存到Session域中
        req.getSession().setAttribute("lastName", cartItem.getName());
        cart.addItem(cartItem);
        System.out.println(cart);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 使用ajax请求将商品添加到购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), book.getPrice(), 1, book.getPrice());
        // 将最后一次添加到购物车的商品保存到Session域中
        req.getSession().setAttribute("lastName", cartItem.getName());
        cart.addItem(cartItem);
        System.out.println(cart);
//        resp.sendRedirect(req.getHeader("Referer"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("totalCount", cart.getTotalCount());
        map.put("lastName", cartItem.getName());
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(map));
    }
}
