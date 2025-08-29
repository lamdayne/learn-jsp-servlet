<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý</title>
</head>

<body>
    <!-- Main Content -->
        <h1 class="page-title">Dashboard Tổng Quan</h1>

        <!-- Stats Grid -->
        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-header">
                    <span class="stat-title">Tổng doanh thu</span>
                    <div class="stat-icon" style="background: linear-gradient(45deg, #10b981, #059669);">
                        <i class="fas fa-dollar-sign"></i>
                    </div>
                </div>
                <div class="stat-value">₫2,450,000</div>
                <div class="stat-change positive">
                    <i class="fas fa-arrow-up"></i>
                    <span>+12.5% so với tháng trước</span>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-header">
                    <span class="stat-title">Đơn hàng mới</span>
                    <div class="stat-icon" style="background: linear-gradient(45deg, #3b82f6, #2563eb);">
                        <i class="fas fa-shopping-bag"></i>
                    </div>
                </div>
                <div class="stat-value">156</div>
                <div class="stat-change positive">
                    <i class="fas fa-arrow-up"></i>
                    <span>+8.2% so với tuần trước</span>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-header">
                    <span class="stat-title">Khách hàng mới</span>
                    <div class="stat-icon" style="background: linear-gradient(45deg, #f59e0b, #d97706);">
                        <i class="fas fa-user-plus"></i>
                    </div>
                </div>
                <div class="stat-value">89</div>
                <div class="stat-change negative">
                    <i class="fas fa-arrow-down"></i>
                    <span>-3.1% so với tuần trước</span>
                </div>
            </div>

            <div class="stat-card">
                <div class="stat-header">
                    <span class="stat-title">Tỷ lệ chuyển đổi</span>
                    <div class="stat-icon" style="background: linear-gradient(45deg, #8b5cf6, #7c3aed);">
                        <i class="fas fa-percentage"></i>
                    </div>
                </div>
                <div class="stat-value">3.2%</div>
                <div class="stat-change positive">
                    <i class="fas fa-arrow-up"></i>
                    <span>+0.5% so với tháng trước</span>
                </div>
            </div>
        </div>

        <!-- Charts Section -->
        <div class="charts-section">
            <div class="chart-card">
                <div class="chart-header">
                    <h3 class="chart-title">Doanh thu 12 tháng gần nhất</h3>
                    <select
                        style="background: rgba(255,255,255,0.1); border: none; color: white; padding: 0.5rem; border-radius: 0.5rem;">
                        <option>2024</option>
                        <option>2023</option>
                    </select>
                </div>
                <div class="chart-placeholder">Biểu đồ doanh thu (Chart.js integration)</div>
            </div>

            <div class="chart-card">
                <div class="chart-header">
                    <h3 class="chart-title">Top sản phẩm bán chạy</h3>
                </div>
                <div class="chart-placeholder">Biểu đồ tròn (Pie chart)</div>
            </div>
        </div>

        <!-- Recent Orders Table -->
        <div class="table-section">
            <div class="table-header">
                <h3>Đơn hàng gần nhất</h3>
                <button
                    style="background: linear-gradient(45deg, #667eea, #764ba2); border: none; color: white; padding: 0.5rem 1rem; border-radius: 0.5rem; cursor: pointer;">
                    Xem tất cả
                </button>
            </div>
            <table class="data-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Khách hàng</th>
                        <th>Sản phẩm</th>
                        <th>Số tiền</th>
                        <th>Trạng thái</th>
                        <th>Ngày</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>#1001</td>
                        <td>Nguyễn Văn A</td>
                        <td>iPhone 15 Pro</td>
                        <td>₫25,000,000</td>
                        <td><span class="status-badge status-active">Đã giao</span></td>
                        <td>27/08/2025</td>
                    </tr>
                    <tr>
                        <td>#1002</td>
                        <td>Trần Thị B</td>
                        <td>MacBook Air M3</td>
                        <td>₫35,000,000</td>
                        <td><span class="status-badge status-pending">Đang xử lý</span></td>
                        <td>26/08/2025</td>
                    </tr>
                    <tr>
                        <td>#1003</td>
                        <td>Lê Văn C</td>
                        <td>iPad Pro</td>
                        <td>₫20,000,000</td>
                        <td><span class="status-badge status-active">Đã giao</span></td>
                        <td>25/08/2025</td>
                    </tr>
                    <tr>
                        <td>#1004</td>
                        <td>Phạm Thị D</td>
                        <td>Apple Watch</td>
                        <td>₫8,000,000</td>
                        <td><span class="status-badge status-inactive">Đã hủy</span></td>
                        <td>24/08/2025</td>
                    </tr>
                </tbody>
            </table>
        </div>
</body>

</html>