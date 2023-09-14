package com.study.service;

import com.study.entity.Book;
import com.study.entity.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    void deleteBookById(Integer id);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Page<Book> page(int pageNumber, int pageSize);

    Page<Book> pageByPrice(int pageNumber, int pageSize, int min, int max);
}
