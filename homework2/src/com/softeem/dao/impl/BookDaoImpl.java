package com.softeem.dao.impl;

import com.softeem.bean.Book;
import com.softeem.dao.BookDao;
import com.softeem.uitl.BaseDao;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public List<Book> findAll() throws SQLException {
        String sql = "select * from t_book";
        BeanListHandler<Book> handler = new BeanListHandler<>(Book.class);
        List<Book> query = queryRunner.query(sql, handler);
        return query;
    }

    @Override
    public void save(Book book) throws SQLException {
        queryRunner.update("insert into t_book values(null,?,?,?,?,?,?)", book.getName(),book.getPrice(),
                book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public void updateById(Book book) throws SQLException {
        queryRunner.update("update t_book set author = ? where id = ?", book.getAuthor(), book.getId());
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        queryRunner.update("delete from t_book where id = ?", id);
    }

    @Override
    public Book findById(Integer id) throws SQLException {
        BeanHandler<Book> handler = new BeanHandler<>(Book.class);
        Book query = queryRunner.query("select * from t_book where id = ?", handler,id);
        return query;
    }

    @Override
    public List<Book> page(Integer pageNumber) throws SQLException {
        String sql = "select * from t_book limit ?,?";
        BeanListHandler<Book> hander = new BeanListHandler<>(Book.class);
        List<Book> deptList = queryRunner.query(sql, hander, (pageNumber - 1) * pageSize, pageSize);
        return deptList;
    }

    @Override
    public Integer pageRecord() throws SQLException {
        String sql = "select count(*) from t_book";
        ScalarHandler<Long> handler = new ScalarHandler<>();
        Long query = queryRunner.query(sql, handler);
        return query.intValue();
    }
}
