<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/19/2021
  Time: 3:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>diachimoithem</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
                            <a href="/khachhang?action=create">Tiếp tục thêm mới khách hàng</a>
                        </p>
                        <p>
                            <a href="/nhanvien?action=create">Tiếp tục thêm mới nhanvien</a>
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
                            <c:forEach items="${diachi}" var="diachi">
                                <tr>
                                    <td>${diachi.getId_diachi()}</td>
                                    <td>${diachi.getSonha()}</td>
                                    <td>${diachi.getXa()}</td>
                                    <td>${diachi.getHuyen()}</td>
                                    <td>${diachi.getTinh()}</td>
                                    <td>${diachi.getQuocgia()}</td>
                                </tr>
                            </c:forEach>

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
