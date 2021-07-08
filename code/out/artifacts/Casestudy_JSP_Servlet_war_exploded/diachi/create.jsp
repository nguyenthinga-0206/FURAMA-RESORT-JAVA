<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/19/2021
  Time: 3:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới địa chỉ</title>
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
                        <p>
                            <a href="/khachhang?action=create">
                                Trở lại thêm mới khách hàng
                            </a>
                        </p>
                        <p>
                            <a href="/khachhang?action=createh">
                                Trở lại thêm mới khách hàng
                            </a>
                        </p>
                        <p>
                            <a href="/nhanvien?action=create">
                                Trở lại thêm mới nhanvien
                            </a>
                        </p>
                        <form method="post">
                            <div class="form-group">
                                <label >Id</label>
                                <input type="text" name="id" class="form-control"  >
                            </div>
                            <div class="form-group">
                                <label> Số nhà:</label>
                                <input type="text" name="sonha" class="form-control"   >
                            </div>
                            <div class="form-group">
                                <label >Xã</label>
                                <input type="text" name="xa" class="form-control" >
                            </div>
                            <div class="form-group">
                                <label >Huyện</label>
                                <input type="text" name="huyen" class="form-control"    >
                            </div>
                            <div class="form-group">
                                <label >Tỉnh</label>
                                <input type="text" name="tinh" class="form-control"   >
                            </div>
                            <div class="form-group">
                                <label >Quốc Gia</label>
                                <input type="text" name="quocgia" class="form-control"  >
                            </div>
                            <button type="submit" name="submit" class="btn btn-primary">thêm mới</button>
                        </form>
                    </div>
                </div>
            </article>
        </div>
    </nav>
    <jsp:include page="/footer.jsp"/>
</div>

</body>
</html>
