package com.study.service.impl;

import com.study.dao.BookDao;
import com.study.dao.impl.BookDaoImpl;
import com.study.entity.Book;
import com.study.entity.Page;
import com.study.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNumber, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        Integer pageTotal = (int) Math.ceil(1.0 * pageTotalCount / pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);

        page.setPageNumber(pageNumber);

        List<Book> bookItems = bookDao.queryForBookItems((page.getPageNumber() - 1) * pageSize, pageSize);
        page.setItems(bookItems);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNumber, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        Integer pageTotal = (int) Math.ceil(1.0 * pageTotalCount / pageSize);
        page.setPageTotalCount(pageTotalCount);
        page.setPageTotal(pageTotal);

        page.setPageNumber(pageNumber);

        List<Book> bookItems = bookDao.queryForBookItemsByPrice((page.getPageNumber() - 1) * pageSize, pageSize,min,
                max);
        page.setItems(bookItems);
        return page;
    }


}
