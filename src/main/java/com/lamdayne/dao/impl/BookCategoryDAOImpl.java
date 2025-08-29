package com.lamdayne.dao.impl;

import com.lamdayne.dao.BookCategoryDAO;
import com.lamdayne.model.BookCategory;
import com.lamdayne.util.XJdbc;
import com.lamdayne.util.XQuery;

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

    }

    @Override
    public void deleteById(Long bookCategoryID) {

    }

    @Override
    public List<BookCategory> findAll() {
        return XQuery.getBeanList(BookCategory.class, findAllSql);
    }

    @Override
    public BookCategory findById(Long bookCategoryID) {
        return XQuery.getSingleBean(BookCategory.class, findByIdSql, bookCategoryID);
    }
}
