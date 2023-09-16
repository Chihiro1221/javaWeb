package com.study.entity;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    //    private Integer totalCount;
//    private Integer totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public Cart() {
    }

    /**
     * 添加商品到购物车
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        // 查询是否已添加到购物车，如果已添加则更新数量，否则添加到购物车
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getTotalPrice().add(item.getPrice()));
        }
    }

    /**
     * 根据id从购物车中删除商品
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 根据id更新购物车中的商品数量
     *
     * @param id
     * @param count
     */
    public void updateItemCount(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(count)));
        }
    }


    public Integer getTotalCount() {
        Integer count = 0;
        for (CartItem item : items.values()) {
            count += item.getCount();
        }

        return count;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal price = new BigDecimal(0);
        for (CartItem item : items.values()) {
            price = price.add(item.getTotalPrice());
        }

        return price;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
