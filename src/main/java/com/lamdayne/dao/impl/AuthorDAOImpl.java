package com.lamdayne.dao.impl;

import com.lamdayne.dao.AuthorDAO;
import com.lamdayne.model.Author;
import com.lamdayne.util.XJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        Long id = XJdbc.insert(createSql, values);
        entity.setAuthorID(id);
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
        List<Author> list = new ArrayList<>();
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findAllSql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Author author = new Author();
                author.setAuthorID(rs.getLong("authorID"));
                author.setAuthorName(rs.getString("authorName"));
                author.setStatus(rs.getBoolean("status"));
                list.add(author);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Author findById(Long authorID) {
        Author author = null;
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
            stmt.setLong(1, authorID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    author = new Author();
                    author.setAuthorID(rs.getLong("authorID"));
                    author.setAuthorName(rs.getString("authorName"));
                    author.setStatus(rs.getBoolean("status"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return author;
    }
}
