<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/22/2021
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa hợp đồng</title>
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
                <a class="nav-link " href="/hopdong">Xem danh sách hợp đồng</a>
                <a class="nav-link " href="/hopdong?action=create">Thêm mới hợp đồng</a>
            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <div class="container">
                        <form method="post">
                            <div class="form-group">
                                <label >Id</label>
                                <input type="text" name="id_hopdong" class="form-control"   value="${hopdong.getId_hopdong()}"  readonly>
                            </div>
                            <div class="form-group">
                                <label>Ngày bắt đầu:</label>
                                <input type="text" name="ngaybatdau" class="form-control" value="${hopdong.getNgaybatdau()} ">
                            </div>
                            <div class="form-group">
                                <label>Ngày kết thúc:</label>
                                <input type="text"  name="ngayketthuc" class="form-control" value="${hopdong.getNgayketthuc()}">
                            </div>
                            <div class="form-group">
                                <label >Số tiền đặt cọc:</label>
                                <input type="text"  name="sotiendatcoc" class="form-control"   value="${hopdong.getSotiendatco()}">
                            </div>
                            <div class="form-group">
                                <label >Tổng số tiền thanh toán:</label>
                                <input type="text"  name="tongsotienthanhtoan" class="form-control" value="${hopdong.getTongsotienthanhtoan()}">
                            </div>
                            <div class="form-group">
                                <label >Tên nhân viên:</label>
                                <select name="id_nhanvien" id="exampleInputPositiona">
                                    <option value=" ${hopdong.getNhanvien().getId_nhanvien()}">
                                        ${hopdong.getNhanvien().getTen_nhanvien()}
                                    </option>
                                    <c:forEach items="${nhanviens}" var="nhanvien">
                                        <option  value="${nhanvien.getId_nhanvien()}">
                                                ${nhanvien.getTen_nhanvien()}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label >Tên khách hàng:</label>
                                <div>
                                    <select name="id_khachhang" id="1exampleInputPositionkh">
                                        <option value=" ${hopdong.getKhachhang().getId_khachhang()}">
                                            ${hopdong.getKhachhang().getTen_khachhang()}
                                        </option>
                                        <c:forEach items="${khachhangs}" var="khachhang">
                                            <option value="${khachhang.getId_khachhang()}" ${khachhang.getId_khachhang()==id_khachhang?"selected":""}>
                                                    ${khachhang.getTen_khachhang()}
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <p>
                                        <a href="/khachhang?action=createhd">Thêm mới khachhang </a>
                                    </p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label >Tên dịch vụ:</label>
                                <select name="id_dichvu" >
                                    <option value="${hopdong.getDichvu().getId_dichvu()}">
                                        ${hopdong.getDichvu().getTen_dichvu()}
                                    </option>
                                    <c:forEach items="${dichvus}" var="dichvu">
                                        <option  value="${dichvu.getId_dichvu()}">
                                                ${dichvu.getTen_dichvu()} +
                                                ${dichvu.gettenKieuthue()}
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
