package com.lamdayne.dao.impl;


import com.lamdayne.dao.UserDAO;
import com.lamdayne.model.User;
import com.lamdayne.util.XJdbc;
import com.lamdayne.util.XQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final String createSql = "INSERT INTO User(userName, passwordHash, phone, email, imgUrl, role, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String updateSql = "UPDATE User SET passwordHash=?, phone=?, email=?, imgUrl=?, role=?, status=? WHERE userID=?";
    private static final String deleteSql = "UPDATE User SET status=false WHERE userID=?";
    private static final String findAllSql = "SELECT * FROM User";
    private static final String findByIdSql = "SELECT * FROM User WHERE userID=?";

    @Override
    public User create(User entity) {
        Object[] values = {
                entity.getUserName(),
                entity.getPasswordHash(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getImgUrl(),
                entity.getRole(),
                entity.getStatus()
        };
        Long userID = XJdbc.insert(createSql, values);
        entity.setUserID(userID);
        return entity;
    }

    @Override
    public void update(User entity) {
        Object[] values = {
                entity.getPasswordHash(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getImgUrl(),
                entity.getRole(),
                entity.getStatus(),
                entity.getUserID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long id) {
        XJdbc.executeUpdate(deleteSql, id);
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findAllSql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getLong("userID"));
                user.setUserName(rs.getString("userName"));
                user.setPasswordHash(rs.getString("passwordHash"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setImgUrl(rs.getString("imgUrl"));
                user.setRole(rs.getBoolean("role"));
                user.setStatus(rs.getBoolean("status"));
                user.setCreateAt(rs.getTimestamp("createAt"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
            stmt.setLong(1, id); // set parameter
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserID(rs.getLong("userID"));
                    user.setUserName(rs.getString("userName"));
                    user.setPasswordHash(rs.getString("passwordHash"));
                    user.setPhone(rs.getString("phone"));
                    user.setEmail(rs.getString("email"));
                    user.setImgUrl(rs.getString("imgUrl"));
                    user.setRole(rs.getBoolean("role"));
                    user.setStatus(rs.getBoolean("status"));
                    user.setCreateAt(rs.getTimestamp("createAt"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
