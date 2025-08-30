package com.lamdayne.dao.impl;

import com.lamdayne.dao.BookCategoryDAO;
import com.lamdayne.model.BookCategory;
import com.lamdayne.util.XJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryDAOImpl implements BookCategoryDAO {
    private static final String createSql = "INSERT INTO BookCategory(bookCategoryName) VALUES ?";
    private static final String updateSql = "UPDATE BookCategory SET bookCategoryName=? WHERE bookCategoryID=?";
    private static final String deleteSql = "";
    private static final String findAllSql = "SELECT * FROM BookCategory";
    private static final String findByIdSql = "SELECT * FROM BookCategory WHERE bookCategoryID=?";

    @Override
    public BookCategory create(BookCategory entity) {
        Object[] values = {
                entity.getBookCategoryName()
        };
        Long bookCategoryID = XJdbc.insert(createSql, values);
        entity.setBookCategoryID(bookCategoryID);
        return entity;
    }

    @Override
    public void update(BookCategory entity) {
        Object[] values = {
                entity.getBookCategoryName()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long bookCategoryID) {

    }

    @Override
    public List<BookCategory> findAll() {
        List<BookCategory> list = new ArrayList<>();
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findAllSql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                BookCategory bookCategory = new BookCategory();
                bookCategory.setBookCategoryID(rs.getLong("bookCategoryID"));
                bookCategory.setBookCategoryName(rs.getString("bookCategoryName"));
                list.add(bookCategory);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public BookCategory findById(Long bookCategoryID) {
        BookCategory bookCategory = null;
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
            stmt.setLong(1, bookCategoryID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    bookCategory = new BookCategory();
                    bookCategory.setBookCategoryID(rs.getLong("bookCategoryID"));
                    bookCategory.setBookCategoryName(rs.getString("bookCategoryName"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bookCategory;
    }
}
