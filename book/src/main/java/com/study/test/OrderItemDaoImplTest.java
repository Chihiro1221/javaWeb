package com.study.test;

import com.study.dao.impl.OrderItemDaoImpl;
import com.study.entity.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null, "伞兵一号", 1, new BigDecimal(100), new BigDecimal(100),
                "123456789"));
    }

}