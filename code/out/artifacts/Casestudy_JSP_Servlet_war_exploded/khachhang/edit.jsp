<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/11/2021
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sửa đổi</title>
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
                            <a  href="/khachhang">Trở lại danh sách User</a>
                        </p>
                        <form method="post">
                            <div class="form-group">
                                <label >Id</label>
                                <input type="text" name="id" class="form-control"   placeholder="id" value="${khachhang.getId_khachhang()}"  readonly>
                            </div>
                            <div class="form-group">
                                <label >Tên:</label>
                                <input type="text" name="ten" class="form-control"  placeholder="ten" value="${khachhang.getTen_khachhang()}">
                            </div>
                            <div class="form-group">
                                <label >Ngày sinh:</label>
                                <input type="text"  name="ngaysinh" class="form-control"  placeholder="Ngày sinh 1999/12/03" value="${khachhang.getNgaysinh()}">
                            </div>
                            <div class="form-group">
                                <label >Giới Tính:</label>
                                <input type="text"  name="gioitinh" class="form-control"  placeholder="giới tính" value="${khachhang.getGioitinh()}">
                            </div>
                            <div class="form-group">
                                <label >Số Cmnd:</label>
                                <input type="text"  name="socmnd" class="form-control"  placeholder="số cmnd" value="${khachhang.getSocmnd()}">
                            </div>
                            <div class="form-group">
                                <label >Số đt:</label>
                                <input type="text"  name="sdt" class="form-control"  placeholder="sdt" value="${khachhang.getSdt()}">
                            </div>
                            <div class="form-group">
                                <label >Email:</label>
                                <input type="text"  name="email" class="form-control"  placeholder="email" value="${khachhang.getEmail()}">
                            </div>
                            <div class="form-group">
                                <label >Loại Khách:</label>
                                <select name="id_loaikhach" id="exampleInputPosition">
                                    <option value="${khachhang.getLoaikhach().getId_loaikhach()}">
                                        ${khachhang.getLoaikhach().getTen_loaikhach()}
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
                                <select name="id_diachi" id="1exampleInputPosition">
                                    <option  value="${khachhang.getDiachi().getId_diachi()}">
                                        Số nhà :${khachhang.getDiachi().getSonha()}  ,Xã: ${khachhang.getDiachi().getXa()} ,Huyện:  ${khachhang.getDiachi().getHuyen()} ,Tỉnh:    ${khachhang.getDiachi().getTinh()}
                                    </option>
                                    <c:forEach items="${diachis}" var="diachis">
                                        <option value="${diachis.getId_diachi()}">
                                            Số nhà :${diachis.getSonha()}  ,Xã: ${diachis.getXa()} ,Huyện:  ${diachis.getHuyen()} ,Tỉnh:    ${diachis.getTinh()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button type="submit" name="submit" class="btn btn-primary">Sửa đổi</button>
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
