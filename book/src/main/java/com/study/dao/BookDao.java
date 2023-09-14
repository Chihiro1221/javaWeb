package com.study.dao;

import com.study.entity.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);

    int updateBook(Book book);

    int deleteBookById(Integer id);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForBookItems(Integer pageNumber, Integer pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForBookItemsByPrice(int i, int pageSize, int min, int max);
}
