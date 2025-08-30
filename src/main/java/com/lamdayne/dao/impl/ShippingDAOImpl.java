package com.lamdayne.dao.impl;

import com.lamdayne.dao.ShippingDAO;
import com.lamdayne.model.Shipping;
import com.lamdayne.util.XJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShippingDAOImpl implements ShippingDAO {
    private static final String createSql = "INSERT INTO Shipping(orderID, address, phoneReceive, receiverName, shippingStatus, shippingDate) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String updateSql = "UPDATE Shipping SET orderID=?, address=?, phoneReceive=?, receiverName=?, shippingStatus=?, shippingDate=? WHERE shippingID=?";
    private static final String deleteSql = "DELETE FROM Shipping WHERE shippingID=?";
    private static final String findAllSql = "SELECT * FROM Shipping";
    private static final String findByIdSql = "SELECT * FROM Shipping WHERE shippingID=?";

    @Override
    public Shipping create(Shipping entity) {
        Object[] values = {
                entity.getOrderID(),
                entity.getAddress(),
                entity.getPhoneReceive(),
                entity.getReceiverName(),
                entity.getShippingStatus(),
                entity.getShippingDate()
        };
        Long id = XJdbc.insert(createSql, values);
        entity.setShippingID(id);
        return entity;
    }

    @Override
    public void update(Shipping entity) {
        Object[] values = {
                entity.getOrderID(),
                entity.getAddress(),
                entity.getPhoneReceive(),
                entity.getReceiverName(),
                entity.getShippingStatus(),
                entity.getShippingDate(),
                entity.getShippingID()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long shippingID) {
        XJdbc.executeUpdate(deleteSql, shippingID);
    }

    @Override
    public List<Shipping> findAll() {
        List<Shipping> list = new ArrayList<>();
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(findAllSql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Shipping shipping = new Shipping();
                shipping.setShippingID(rs.getLong("shippingID"));
                shipping.setOrderID(rs.getLong("orderID"));
                shipping.setAddress(rs.getString("address"));
                shipping.setPhoneReceive(rs.getString("phoneReceive"));
                shipping.setReceiverName(rs.getString("receiverName"));
                shipping.setShippingStatus(rs.getString("shippingStatus"));
                shipping.setShippingDate(rs.getDate("shippingDate"));
                list.add(shipping);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Shipping findById(Long shippingID) {
        Shipping shipping = null;
        try (Connection conn = XJdbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
            stmt.setLong(1, shippingID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    shipping = new Shipping();
                    shipping.setShippingID(rs.getLong("shippingID"));
                    shipping.setOrderID(rs.getLong("orderID"));
                    shipping.setAddress(rs.getString("address"));
                    shipping.setPhoneReceive(rs.getString("phoneReceive"));
                    shipping.setReceiverName(rs.getString("receiverName"));
                    shipping.setShippingStatus(rs.getString("shippingStatus"));
                    shipping.setShippingDate(rs.getDate("shippingDate"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return shipping;
    }
}
