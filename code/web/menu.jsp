<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/23/2021
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<nav class="navbar navbar-expand-lg  navbar-dark bd-bark  " style="background: black; color: white">--%>
<%--    <a class="navbar-brand" href="#"> 🏠</a>--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--        <span class="navbar-toggler-icon"> </span>--%>
<%--    </button>--%>
<%--    <a class="navbar-brand" href="#">--%>
<%--        <span class="glyphicon glyphicon-home"></span>--%>
<%--        🏠--%>
<%--    </a>--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--    </button>--%>
<nav class="navbar navbar-expand-lg navbar-light" style="background:#efa2a9 ">
    <a class="navbar-brand" href="#">Trang Chủ</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon">🏠</span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="nav nav-tabs mr-auto">
            <li class="nav-item">
                <a class="nav-link "  style="background: #efa2a9; color: white" href="/index.jsp">Logout</a>
            </li>
            <li class="nav-item">
                <a class="nav-link "  style="background: #efa2a9; color: white" href="/nhanvien">Nhân Viên</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" style="background: #efa2a9; color: white" href="/khachhang">Khách Hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" style="background: #efa2a9; color: white" href="/dichvu">Dịch vụ</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link " style="background: #efa2a9; color: white" href="/hopdong">Hợp đồng</a>
            </li>
        </ul>
        <ul class="navbar-nav mr-right">
            <li class="nav-item">
                <form method="post" action="${timkiem}?action=search">
                       <input type="search" name="name" placeholder="tìm kiếm?" aria-describedby="button-addon4" class="form-control border-0" value="${value_key}">
                </form>
            </li>
        </ul>
    </div>
</nav>

