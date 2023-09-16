package com.study.web;

import com.study.entity.Cart;
import com.study.entity.User;
import com.study.service.impl.OrderServiceImpl;
import com.study.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
    private OrderServiceImpl orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        String orderId = null;
        orderId = orderService.createOrder(cart, user.getId());
        req.setAttribute("orderId", orderId);
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
    }
}
