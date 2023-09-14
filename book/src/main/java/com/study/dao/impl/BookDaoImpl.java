package com.study.dao.impl;

import com.study.dao.BookDao;
import com.study.entity.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
                book.getImgPath());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),
                book.getStock(),
                book.getImgPath(), book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from book where id = ?";
        return update(sql, id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` from book where id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` from book";
        return queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from book";
        return (Integer) queryForSingleValue(sql);
    }

    @Override
    public List<Book> queryForBookItems(Integer pageNumber, Integer pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` from book limit ?,?";
        return queryForList(Book.class, sql, pageNumber, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from book where price between ? and ?";
        return (Integer) queryForSingleValue(sql, min, max);
    }

    @Override
    public List<Book> queryForBookItemsByPrice(int i, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` from book where price " +
                "between ? and ? order by price limit ?,?";
        return queryForList(Book.class, sql, min, max, i, pageSize);
    }
}
