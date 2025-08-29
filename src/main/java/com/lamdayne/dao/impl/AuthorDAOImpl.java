package com.lamdayne.dao.impl;

import com.lamdayne.dao.AuthorDAO;
import com.lamdayne.model.Author;
import com.lamdayne.util.XJdbc;
import com.lamdayne.util.XQuery;

import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    private static final String createSql = "INSERT INTO Author(authorName, status) VALUES ?, ?";
    private static final String updateSql = "UPDATE Author SET authorName=?, status=? WHERE authorID=?";
    private static final String deleteSql = "UPDATE Author SET status=0 WHERE authorID=?";
    private static final String findAllSql = "SELECT * FROM Author";
    private static final String findByIdSql = "SELECT * FROM Author WHERE authorID=?";

    @Override
    public Author create(Author entity) {
        Object[] values = {
                entity.getAuthorName()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Author entity) {
        Object[] values = {
                entity.getAuthorName(),
                entity.getStatus(),
                entity.getAuthorID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long authorID) {
        XJdbc.executeUpdate(deleteSql, authorID);
    }

    @Override
    public List<Author> findAll() {
        return XQuery.getBeanList(Author.class, findAllSql);
    }

    @Override
    public Author findById(Long authorID) {
        return XQuery.getSingleBean(Author.class, findByIdSql, authorID);
    }
}
