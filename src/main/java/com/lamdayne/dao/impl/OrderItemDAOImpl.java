package com.lamdayne.dao.impl;

import com.lamdayne.dao.OrderItemDAO;
import com.lamdayne.model.OrderItem;
import com.lamdayne.util.XJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAOImpl implements OrderItemDAO {
    private static final String createSql = "INSERT INTO OrderItem(orderID, bookID, quantity, price) VALUES (?, ?, ?, ?)";
    private static final String updateSql = "UPDATE Order SET orderID=?, bookID=?, quantity=?, price=? WHERE orderItemID=?";
    private static final String deleteSql = "DELETE FROM Order WHERE orderItemID=?";
    private static final String findAllSql = "SELECT * FROM Order";
    private static final String findByIdSql = "SELECT * FROM Order WHERE orderItemID=?";

    @Override
    public OrderItem create(OrderItem entity) {
        Object[] values = {
                entity.getOrderID(),
                entity.getBookID(),
                entity.getQuantity(),
                entity.getPrice()
        };
        Long id = XJdbc.insert(createSql, values);
        entity.setOrderItemID(id);
        return entity;
    }

    @Override
    public void update(OrderItem entity) {
        Object[] values = {
                entity.getOrderID(),
                entity.getBookID(),
                entity.getQuantity(),
                entity.getPrice(),
                entity.getOrderItemID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long orderItemID) {
        XJdbc.executeUpdate(deleteSql, orderItemID);
    }

    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> list = new ArrayList<>();
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findAllSql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemID(rs.getLong("orderItemID"));
                orderItem.setOrderID(rs.getLong("orderID"));
                orderItem.setBookID(rs.getLong("bookID"));
                orderItem.setQuantity(rs.getLong("quantity"));
                orderItem.setPrice(rs.getDouble("price"));
                list.add(orderItem);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public OrderItem findById(Long orderItemID) {
        OrderItem orderItem = null;
        try (Connection conn = XJdbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
            stmt.setLong(1, orderItemID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    orderItem = new OrderItem();
                    orderItem.setOrderItemID(rs.getLong("orderItemID"));
                    orderItem.setOrderID(rs.getLong("orderID"));
                    orderItem.setBookID(rs.getLong("bookID"));
                    orderItem.setQuantity(rs.getLong("quantity"));
                    orderItem.setPrice(rs.getDouble(("price")));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orderItem;
    }
}
