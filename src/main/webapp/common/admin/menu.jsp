<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!-- Sidebar -->
<aside class="sidebar" id="sidebar">
    <div class="sidebar-header">
        <i class="fas fa-chart-line"></i>
        <span class="logo">AdminPro</span>
    </div>
    <nav>
        <ul class="nav-menu">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/dashboard" class="nav-link active">
                    <i class="fas fa-home"></i>
                    <span class="nav-text">Dashboard</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/list-user" class="nav-link">
                    <i class="fas fa-users"></i>
                    <span class="nav-text">Người dùng</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/list-cart" class="nav-link">
                    <i class="fas fa-shopping-cart"></i>
                    <span class="nav-text">Đơn hàng</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/list-product" class="nav-link">
                    <i class="fas fa-box"></i>
                    <span class="nav-text">Sản phẩm</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/revenue" class="nav-link">
                    <i class="fas fa-chart-bar"></i>
                    <span class="nav-text">Báo cáo</span>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/setting" class="nav-link">
                    <i class="fas fa-cog"></i>
                    <span class="nav-text">Cài đặt</span>
                </a>
            </li>
        </ul>
    </nav>
</aside>