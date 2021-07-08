<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/21/2021
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới khách hàng</title>
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
            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <div class="container">
                        <p>
                            <a  href="/hopdong?action=create">Trở lại thêm mới hợp đồng</a>
                        </p>
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
                                <label >Ngày sinh:</label>
                                <input type="text"  name="ngaysinh" class="form-control"  placeholder="Ngày sinh 1999/12/03">
                            </div>
                            <div class="form-group">
                                <label >Giới Tính:</label>
                                <input type="text"  name="gioitinh" class="form-control"  placeholder="giới tính">
                            </div>
                            <div class="form-group">
                                <label >Số Cmnd:</label>
                                <input type="text"  name="socmnd" class="form-control"  placeholder="số cmnd">
                            </div>
                            <div class="form-group">
                                <label >Số đt:</label>
                                <input type="text"  name="sdt" class="form-control"  placeholder="sdt">
                            </div>
                            <div class="form-group">
                                <label >Email:</label>
                                <input type="text"  name="email" class="form-control"  placeholder="email">
                            </div>
                            <div class="form-group">
                                <label >Loại Khách:</label>
                                <select name="id_loaikhach" id="exampleInputPosition">
                                    <option>
                                        Loại khách:
                                    </option>
                                    <c:forEach items="${loaikhachs}" var="loaikhachs">
                                        <option  value="${loaikhachs.getId_loaikhach()}">
                                                ${loaikhachs.getTen_loaikhach()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label >Địa chỉ:</label>
                                <div>
                                    <select name="id_diachi" id="1exampleInputPosition">
                                        <option>
                                            Địa chỉ
                                        </option>
                                        <c:forEach items="${diachis}" var="diachis">
                                            <option value="${diachis.getId_diachi()}" ${diachis.getId_diachi()==id_diachi?"selected":""}>
                                                Số nhà :${diachis.getSonha()}  ,Xã: ${diachis.getXa()} ,Huyện:  ${diachis.getHuyen()} ,Tỉnh:    ${diachis.getTinh()}
                                            </option>
                                        </c:forEach>

                                    </select>
                                    <p> <a href="/diachi?action=createkh">Thêm mới địa chỉ</a></p>
                                </div>
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
