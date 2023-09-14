package com.study.test;

import com.study.entity.Book;
import com.study.entity.Page;
import com.study.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    BookServiceImpl bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "伞兵3二号", "马飞飞", new BigDecimal(9.9), 20, 0, null));
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23, "伞兵二号", "马飞飞", new BigDecimal(9999), 119999, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(4, 4);
        System.out.println(page);
    }
}