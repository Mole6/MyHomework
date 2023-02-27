package com.softeem.test;

import com.softeem.bean.Book;
import com.softeem.dao.BookDao;
import com.softeem.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImplTest {

    @Test
    public void findAll() throws SQLException {
        BookDao book = new BookDaoImpl();
        List<Book> books = book.findAll();
        for (Book book1 : books) {
            System.out.println(book1);
        }
    }

    @Test
    public void save() throws SQLException {
        BookDao book = new BookDaoImpl();
        Book books = new Book();
        books.setName("三国演义");
        books.setPrice(BigDecimal.valueOf(30.00));
        books.setAuthor("吴承恩");
        books.setSales(666);
        books.setStock(22);
        books.setImg_path("static/img/default.jpg");
        book.save(books);
    }

    @Test
    public void updateById() throws SQLException {
        BookDao book = new BookDaoImpl();
        Book books = new Book();
        books.setAuthor("罗贯中");
        books.setId(21);
        book.updateById(books);
    }

    @Test
    public void deleteById() throws SQLException {
        BookDao book = new BookDaoImpl();
        book.deleteById(21);
    }

    @Test
    public void findById() throws SQLException {
        BookDao book = new BookDaoImpl();
        Book byId = book.findById(3);
        System.out.println(byId);
    }

    @Test
    public void page() throws SQLException {
        BookDao book = new BookDaoImpl();
        List<Book> page = book.page(2);
        for (Book book1 : page) {
            System.out.println(book1);
        }
    }

    @Test
    public void pageRecord() throws SQLException {
        BookDao book = new BookDaoImpl();
        Integer integer = book.pageRecord();
        System.out.println(integer);
    }
}