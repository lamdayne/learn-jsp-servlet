<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>${pageTitle != null ? pageTitle : "Trang chủ"}</title>

        <!-- css -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/web/css/normalize.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/web/icomoon/icomoon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/web/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/web/css/style.css">


    </head>
    <body>
        <!-- header -->
        <%@ include file="/common/web/header.jsp" %>
        <!-- header -->

        <section id="billboard">
            <div class="container">
                <!-- <dec:body/> -->
                <jsp:include page="${body}" />
            </div>
        </section>

        <!-- footer -->
        <%@ include file="/common/web/footer.jsp" %>
        <!-- footer -->

    <script src="${pageContext.request.contextPath}/assets/web/js/jquery-1.11.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/assets/web/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/assets/web/js/script.js"></script>

    </body>
</html>