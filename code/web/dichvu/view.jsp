<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/21/2021
  Time: 2:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>thông tin địa chỉ</title>
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
                <a class="nav-link " href="/dichvu">danh sách dịch vụ</a>
                <a class="nav-link " href="/dichvu?action=create">Thêm mới dịch vụ</a>
            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <div class="container">
                        <h3>Dịch vụ mới thêm</h3>
                        <table class="table table-hover" id="tableKhachhang">
                            <tr>
                                <th>Id</th>
                                <th>Tên Dịch Vụ</th>
                                <th>Diện Tích</th>
                                <th>Chi Phí</th>
                                <th>Số người</th>
                                <th>Kiểu Dịch Vụ</th>
                            </tr>
                            <tr>
                                <td>${dichvu.getId_dichvu()}</td>
                                <td>${dichvu.getTen_dichvu()}</td>
                                <td>${dichvu.getDientich()}</td>
                                <td>${dichvu.getChiphi()}</td>
                                <td>${dichvu.getSonguoi()}</td>
                                <td>${dichvu.getKieuthue().getTen_kieuthue()}</td>
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


