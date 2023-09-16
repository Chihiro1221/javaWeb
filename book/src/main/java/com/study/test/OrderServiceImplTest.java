package com.study.test;

import com.study.entity.Cart;
import com.study.entity.CartItem;
import com.study.entity.Order;
import com.study.entity.OrderItem;
import com.study.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    private OrderServiceImpl orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "伞兵二号", new BigDecimal(100), 2, new BigDecimal(200)));

        System.out.println(orderService.createOrder(cart, 1));

    }
}