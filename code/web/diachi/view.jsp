<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/20/2021
  Time: 1:44 PM
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
                <a class="nav-link " href="/diachi">danh sách dia chi</a>
                <a class="nav-link " href="/diachi?action=create">Thêm mới địa chỉ</a>
                <a class="nav-link " href="/dichvu?action=search">tìm kiếm địa chỉ</a>
            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <div class="container">
                        <h3>địa chỉ mới thêm</h3>
                        <p>
                            <a href="/nhanvien">Trở lại danh sách nhân viên</a>
                        </p>
                        <p>
                            <a href="/khachhang">Trở lại danh sách khách hàng</a>
                        </p>
                        <table class="table table-hover" id="tableKhachhang">
                            <tr>
                                <th>id_diachi</th>
                                <th>số nhà</th>
                                <th>Xã</th>
                                <th>Huyện</th>
                                <th>Tỉnh</th>
                                <th>Quốc gia</th>
                            </tr>
                            <%--        <c:forEach items="${diachi}" var="diachi">--%>
                            <tr>
                                <td>${diachi.getId_diachi()}</td>
                                <td>${diachi.getSonha()}</td>
                                <td>${diachi.getXa()}</td>
                                <td>${diachi.getHuyen()}</td>
                                <td>${diachi.getTinh()}</td>
                                <td>${diachi.getQuocgia()}</td>
                            </tr>
                            <%--        </c:forEach>--%>
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