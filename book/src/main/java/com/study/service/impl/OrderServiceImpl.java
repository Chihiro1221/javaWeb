package com.study.service.impl;

import com.study.dao.impl.OrderDaoImpl;
import com.study.dao.impl.OrderItemDaoImpl;
import com.study.entity.*;
import com.study.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    private BookServiceImpl bookService = new BookServiceImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        int n = 12 / 0;
        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
            Book book = bookService.queryBookById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookService.updateBook(book);
            orderItemDao.saveOrderItem(orderItem);
        }

        return orderId;
    }
}
