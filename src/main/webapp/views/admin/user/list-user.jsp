<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageContent != null ? pageContent : "Quản Lý"}</title>
</head>

<body>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Tên đăng nhập</th>
                <th scope="col">Mật khẩu</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Email</th>
                <th scope="col">Role</th>
                <th scope="col">Trạng thái</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>0123456789</td>
                <td>mark@example.com</td>
                <td>Admin</td>
                <td>Active</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>0987654321</td>
                <td>jacob@example.com</td>
                <td>User</td>
                <td>Inactive</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>0112233445</td>
                <td>larry@example.com</td>
                <td>User</td>
                <td>Active</td>
            </tr>
            <tr>
                <th scope="row">4</th>
                <td>Emma</td>
                <td>Watson</td>
                <td>0223344556</td>
                <td>emma@example.com</td>
                <td>Moderator</td>
                <td>Active</td>
            </tr>
            <tr>
                <th scope="row">5</th>
                <td>John</td>
                <td>Doe</td>
                <td>0334455667</td>
                <td>john@example.com</td>
                <td>User</td>
                <td>Inactive</td>
            </tr>
            <tr>
                <th scope="row">6</th>
                <td>Jane</td>
                <td>Smith</td>
                <td>0445566778</td>
                <td>jane@example.com</td>
                <td>Admin</td>
                <td>Active</td>
            </tr>
            <tr>
                <th scope="row">7</th>
                <td>Michael</td>
                <td>Brown</td>
                <td>0556677889</td>
                <td>michael@example.com</td>
                <td>User</td>
                <td>Active</td>
            </tr>
            <tr>
                <th scope="row">8</th>
                <td>Linda</td>
                <td>Johnson</td>
                <td>0667788990</td>
                <td>linda@example.com</td>
                <td>User</td>
                <td>Inactive</td>
            </tr>
            <tr>
                <th scope="row">9</th>
                <td>Robert</td>
                <td>Williams</td>
                <td>0778899001</td>
                <td>robert@example.com</td>
                <td>Moderator</td>
                <td>Active</td>
            </tr>
            <tr>
                <th scope="row">10</th>
                <td>Patricia</td>
                <td>Jones</td>
                <td>0889900112</td>
                <td>patricia@example.com</td>
                <td>User</td>
                <td>Active</td>
            </tr>
        </tbody>
    </table>
    <div class="container mt-5">
        <nav aria-label="Pagination Navigation">
            <ul class="pagination justify-content-center" id="pagination">
                <!-- Pagination sẽ được tạo bằng JavaScript -->
            </ul>
        </nav>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/admin/js/pagination.js"></script>
</body>

</html>