<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/19/2021
  Time: 6:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới khách hàng</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
                <a class="nav-link " href="/dichvu">danh sách dịch vụ</a>
                <a class="nav-link " href="/dichvu?action=create">Thêm mới dịch vụ</a>
            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <div class="container">

                        <form method="post">
                            <div class="form-group">
                                <label >Id</label>
                                <input type="text" name="id" class="form-control"   placeholder="id">
                            </div>
                            <div class="form-group">
                                <label >Tên:</label>
                                <input type="text" name="ten" class="form-control"  placeholder="ten">
                            </div>
                            <div class="form-group">
                                <label >Diện Tích:</label>
                                <input type="text"  name="dientich" class="form-control"  >
                            </div>
                            <div class="form-group">
                                <label >Chi Phí:</label>
                                <input type="text"  name="chiphi" class="form-control"   >
                            </div>
                            <div class="form-group">
                                <label >Số Người:</label>
                                <input type="text"  name="songuoi" class="form-control"  >
                            </div>
                            <div class="form-group">
                                <label >Kiểu Thuê:</label>
                                <select name="id_kieuthue" id="exampleInputPosition">
                                    <option>
                                        Kiểu Thuê
                                    </option>
                                    <c:forEach items="${kieuthue}" var="kieuthue">
                                        <option  value="${kieuthue.getId_kieuthue()}">
                                                ${kieuthue.getTen_kieuthue()}
                                        </option>
                                    </c:forEach>
                                </select>
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

