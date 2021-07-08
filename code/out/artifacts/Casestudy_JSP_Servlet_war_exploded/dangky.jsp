<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/28/2021
  Time: 2:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="cs.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent" style="background: #efa2a9">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <h2 style="color: black">Đăng Ký</h2>
        </div>

        <form method="post">
            <input type="text" id="ten" class="fadeIn second" name="ten" placeholder="Tên đăng nhập">
            <input type="text" id="matkhau" class="fadeIn third" name="matkhau" placeholder="Mật khấu">
            <input type="submit" class="fadeIn fourth" value="Đăng Ký">
        </form>
        <c:if test="${message != null }">
            <span style="color:#007bff">${message}</span>
        </c:if>
        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="/index.jsp">Đăng Nhập</a>
        </div>
    </div>
</div>
</body>
</html>
