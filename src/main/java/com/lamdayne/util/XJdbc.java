package com.lamdayne.util;

import java.sql.*;

public class XJdbc {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/BookStore?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static Connection connection;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isReady() {
        try {
            return (connection != null && !connection.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static PreparedStatement getStmt(String sql, Object... values) throws SQLException {
        Connection conn = XJdbc.getConnection();
        PreparedStatement stmt = sql.trim().startsWith("{") ? conn.prepareCall(sql) : conn.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i + 1, values[i]);
        }
        return stmt;
    }

    public static int executeUpdate(String sql, Object... values) {
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, values);
            return stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static ResultSet executeQuery(String sql, Object... values) {
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, values);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Long insert(String sql, Object... values) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet keys = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Set parameters
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }

            // Execute insert
            stmt.executeUpdate();

            // Get generated ID
            keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                return keys.getLong(1);
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Lỗi insert: " + e.getMessage(), e);
        } finally {
            try {
                if (keys != null) keys.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
