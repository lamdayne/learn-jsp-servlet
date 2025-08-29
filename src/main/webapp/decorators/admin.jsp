<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle != null ? pageTitle : "Trang Quản Lý"}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/admin/css/style.css">
</head>
<body>

    <div class="dashboard" id="dashboard">
        <!-- Sidebar -->
        <%@ include file="/common/admin/menu.jsp" %>
        <!-- Sidebar -->

        <!-- header -->
        <%@ include file="/common/admin/header.jsp" %>
        <!-- header -->
    
        <main class="main-content">
            <!-- <dec:body/> -->
            <jsp:include page="${pageContent}" />
        </main>
    
        <!-- footer -->
        <%@ include file="/common/admin/footer.jsp" %>
        <!-- footer -->
    </div>

	<script src="${pageContext.request.contextPath}/assets/admin/js/index.js"></script>
</body>
</html>