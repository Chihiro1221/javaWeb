package com.study.test;

import com.study.dao.impl.OrderDaoImpl;
import com.study.dao.impl.OrderItemDaoImpl;
import com.study.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    private OrderDaoImpl orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("123456789", new Date(), new BigDecimal(100), 0, 1));
    }
}