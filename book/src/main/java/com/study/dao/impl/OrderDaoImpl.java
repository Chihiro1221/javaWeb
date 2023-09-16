package com.study.dao.impl;

import com.study.dao.OrderDao;
import com.study.entity.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(),
                order.getUserId());
    }
}
