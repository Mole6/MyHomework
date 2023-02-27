package com.softeem.servlet;

import com.softeem.bean.Book;
import com.softeem.dao.BookDao;
import com.softeem.dao.impl.BookDaoImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "BookAddServlet",value = "/BookAddServlet")
public class BookAddServlet extends HttpServlet {
    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //传递网页所获取的信息
        String name = request.getParameter("name");
        String prices = request.getParameter("price");
        String author = request.getParameter("author");
        int sales = Integer.parseInt(request.getParameter("sales"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String img_path = request.getParameter("img_path");
//封装成book对象
        BigDecimal price = new BigDecimal(prices);
        Book book = new Book(null, name,price, author, sales, stock, img_path);
        BookDao bookDao = new BookDaoImpl();
        bookDao.save(book);//向数据库中添加一条记录
        response.sendRedirect("addBook.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
