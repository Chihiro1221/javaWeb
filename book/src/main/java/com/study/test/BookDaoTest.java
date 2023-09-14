package com.study.test;

import com.study.dao.impl.BookDaoImpl;
import com.study.entity.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "伞兵一号", "卢本伟", new BigDecimal(9999), 119999, 1, null));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "伞兵二号", "马飞飞", new BigDecimal(9999), 119999, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForBookItems() {
        for (Book book : bookDao.queryForBookItems(0, 4)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForBookItemsByPrice() {
        for (Book book : bookDao.queryForBookItems(0, 4)) {
            System.out.println(book);
        }
    }
}