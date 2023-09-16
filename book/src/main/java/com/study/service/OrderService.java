package com.study.service;

import com.study.entity.Cart;

public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
