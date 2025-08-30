package com.lamdayne.dao.impl;

import com.lamdayne.dao.BookDAO;
import com.lamdayne.model.Book;
import com.lamdayne.util.XJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private static final String createSql = "INSERT INTO Book(bookName, bookCategoryID, description, authorID, price, imgUrl, stockQuantity, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String updateSql = "UPDATE Book SET bookName=?, bookCategoryID=?, description=?, authorID=?, price=?, imgUrl=?, stockQuantity=?, status=? WHERE bookID=?";
    private static final String deleteSql = "UPDATE Book SET status=false WHERE bookID=?";
    private static final String findAllSql = "SELECT * FROM Book";
    private static final String findByIdSql = "SELECT * FROM Book WHERE bookID=?";

    @Override
    public Book create(Book entity) {
        Object[] values = {
                entity.getBookName(),
                entity.getBookCategoryID(),
                entity.getDescription(),
                entity.getAuthorID(),
                entity.getPrice(),
                entity.getImgUrl(),
                entity.getStockQuantity(),
                entity.getStatus()
        };
        Long id = XJdbc.insert(createSql, values);
        entity.setBookID(id);
        return entity;
    }

    @Override
    public void update(Book entity) {
        Object[] values = {
                entity.getBookName(),
                entity.getBookCategoryID(),
                entity.getDescription(),
                entity.getAuthorID(),
                entity.getPrice(),
                entity.getImgUrl(),
                entity.getStockQuantity(),
                entity.getStatus(),
                entity.getBookID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long bookID) {
        XJdbc.executeUpdate(deleteSql, bookID);
    }

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findAllSql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getLong("bookID"));
                book.setBookName(rs.getString("bookName"));
                book.setBookCategoryID(rs.getLong("bookCategoryID"));
                book.setDescription(rs.getString("description"));
                book.setAuthorID(rs.getLong("authorID"));
                book.setPrice(rs.getDouble("price"));
                book.setImgUrl(rs.getString("imgUrl"));
                book.setStockQuantity(rs.getLong("stockQuantity"));
                book.setCreateBy(rs.getLong("createBy"));
                book.setCreateAt(rs.getDate("createAt"));
                book.setModifyBy(rs.getLong("modifyBy"));
                book.setModifyAt(rs.getDate("modifyAt"));
                book.setStatus(rs.getBoolean("status"));
                list.add(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Book findById(Long bookID) {
        Book book = null;
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
            stmt.setLong(1, bookID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    book = new Book();
                    book.setBookID(rs.getLong("bookID"));
                    book.setBookName(rs.getString("bookName"));
                    book.setBookCategoryID(rs.getLong("bookCategoryID"));
                    book.setDescription(rs.getString("description"));
                    book.setAuthorID(rs.getLong("authorID"));
                    book.setPrice(rs.getDouble("price"));
                    book.setImgUrl(rs.getString("imgUrl"));
                    book.setStockQuantity(rs.getLong("stockQuantity"));
                    book.setCreateBy(rs.getLong("createBy"));
                    book.setCreateAt(rs.getDate("createAt"));
                    book.setModifyBy(rs.getLong("modifyBy"));
                    book.setModifyAt(rs.getDate("modifyAt"));
                    book.setStatus(rs.getBoolean("status"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return book;
    }
}
