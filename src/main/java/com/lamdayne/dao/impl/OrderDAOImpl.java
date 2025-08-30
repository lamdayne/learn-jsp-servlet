package com.lamdayne.dao.impl;

import com.lamdayne.dao.OrderDAO;
import com.lamdayne.model.Order;
import com.lamdayne.util.XJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final String createSql = "INSERT INTO Order(userID, totalAmount, status) VALUES (?, ?, ?)";
    private static final String updateSql = "UPDATE Order SET userID=?, totalAmount=?, status=? WHERE orderID=?";
    private static final String deleteSql = "DELETE FROM Order WHERE orderID=?";
    private static final String findAllSql = "SELECT * FROM Order";
    private static final String findByIdSql = "SELECT * FROM Order WHERE orderID=?";

    @Override
    public Order create(Order entity) {
        Object[] values = {
                entity.getUserID(),
                entity.getTotalAmount(),
                entity.getStatus()
        };
        Long id = XJdbc.insert(createSql, values);
        entity.setOrderID(id);
        return entity;
    }

    @Override
    public void update(Order entity) {
        Object[] values = {
                entity.getUserID(),
                entity.getTotalAmount(),
                entity.getStatus(),
                entity.getOrderID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long orderID) {
        XJdbc.executeUpdate(deleteSql, orderID);
    }

    @Override
    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findAllSql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getLong("orderID"));
                order.setUserID(rs.getLong("userID"));
                order.setTotalAmount((rs.getDouble("totalAmount")));
                order.setStatus(rs.getString("status"));
                order.setCreateBy(rs.getLong("createBy"));
                order.setCreateAt(rs.getDate("createAt"));
                list.add(order);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Order findById(Long orderID) {
        Order order = null;
        try (Connection conn = XJdbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
            stmt.setLong(1, orderID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    order = new Order();
                    order.setOrderID(rs.getLong("orderID"));
                    order.setUserID(rs.getLong("userID"));
                    order.setTotalAmount((rs.getDouble("totalAmount")));
                    order.setStatus(rs.getString("status"));
                    order.setCreateBy(rs.getLong("createBy"));
                    order.setCreateAt(rs.getDate("createAt"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }
}
