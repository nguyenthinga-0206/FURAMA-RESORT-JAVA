<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/21/2021
  Time: 2:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết  khách hàng </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
    <jsp:include page="/header.jsp"/>
    <jsp:include page="/menu.jsp"/>
    <nav >
        <div class="row container">
            <article class="col-sm-3">
                <a class="nav-link " href="/khachhang">Xem danh sách khách hàng</a>
                <a class="nav-link " href="/khachhang?action=create">Thêm mới khách hàng</a>
                <a class="nav-link " href="/khachhang?action=search">tìm kiếm khách hàng</a>
            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <div>
                        <p>
                        <p>
                            <a href="/hopdong">Trở lại danh sách hợp đồng</a>
                        </p>
                        </p>
                        <table class="table table-hover" id="tablenhanvien">
                            <tr>
                                <th>Id</th>
                                <th>Tên</th>
                                <th>Ngày Sinh</th>
                                <th>Giới Tính</th>
                                <th>Số Cmnd</th>
                                <th>Số điện thoại</th>
                                <th>Email</th>
                                <th>Loại Khách</th>
                                <th>Địa Chỉ</th>
                            </tr>
                            <tr>
                                <td>${khachhang.getId_khachhang()}</td>
                                <td>${khachhang.getTen_khachhang()}</td>
                                <td>${khachhang.getNgaysinh()}</td>
                                <td>${khachhang.getGioitinh()}</td>
                                <td>${khachhang.getSocmnd()}</td>
                                <td>${khachhang.getSdt()}</td>
                                <td>${khachhang.getEmail()}</td>
                                <td>${khachhang.getLoaikhach().getTen_loaikhach()}</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </article>
        </div>
    </nav>
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>
