package com.study.test;

import com.study.entity.Cart;
import com.study.entity.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "伞兵二号", new BigDecimal(100), 2, new BigDecimal(200)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "伞兵二号", new BigDecimal(100), 2, new BigDecimal(200)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "伞兵二号", new BigDecimal(100), 2, new BigDecimal(200)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateItemCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "伞兵一号", new BigDecimal(1000), 1, new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "伞兵二号", new BigDecimal(100), 2, new BigDecimal(200)));

        cart.deleteItem(1);
        cart.updateItemCount(2, 10);

        System.out.println(cart);
    }
}