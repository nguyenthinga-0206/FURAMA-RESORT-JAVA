<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/19/2021
  Time: 2:53 PM
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
<body>
<div class="container-fluid">
    <jsp:include page="/header.jsp"/>
    <jsp:include page="/menu.jsp"/>
    <nav >
        <div class="row container">
            <article class="col-sm-3">
                <a class="nav-link " href="/nhanvien">Xem danh sách nhân viên</a>
                <a class="nav-link " href="/nhanvien?action=create">Thêm mới nhân viên</a>
            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <form method="post">
                        <div class="form-group">
                            <label >Id</label>
                            <input type="text" name="id" class="form-control"  value="${nhanvien.getId_nhanvien()}"  readonly>
                        </div>
                        <div class="form-group">
                            <label >Tên:</label>
                            <input type="text" name="ten" class="form-control" value="${nhanvien.getTen_nhanvien()}">
                        </div>
                        <div class="form-group">
                            <label >Ngày sinh:</label>
                            <input type="text"  name="ngaysinh" class="form-control"  value="${nhanvien.getNgaysinh()}">
                        </div>
                        <div class="form-group">
                            <label >Số CMND:</label>
                            <input type="text"  name="socmnd" class="form-control" value="${nhanvien.getSocmnd()}">
                        </div>
                        <th>Id</th>--%>

                        <div class="form-group">
                            <label >Số đt:</label>
                            <input type="text"  name="sdt" class="form-control"  value="${nhanvien.getSdt()}">
                        </div>
                        <div class="form-group ">
                            <label >Email:</label>
                            <input type="text"  name="email" class="form-control"  value="${nhanvien.getEmail()}">
                        </div>
                        <div class="form-group">
                            <label >Luong:</label>
                            <input type="text"  name="luong" class="form-control" value="${nhanvien.getLuong()}">
                        </div>
                        <div class="form-group">
                            <label >Địa chỉ:</label>
                            <div>
                                <select name="id_diachi" id="1exampleInputPosition">
                                    <option  value="${nhanvien.getDiachi().getId_diachi()}">
                                        Số nhà :${nhanvien.getDiachi().getSonha()}  ,Xã: ${nhanvien.getDiachi().getXa()} ,Huyện:  ${nhanvien.getDiachi().getHuyen()} ,Tỉnh:    ${nhanvien.getDiachi().getTinh()}
                                    </option>
                                    <c:forEach items="${diachis}" var="diachis">
                                        <option value="${diachis.getId_diachi()}">
                                            Số nhà :${diachis.getSonha()}  ,Xã: ${diachis.getXa()} ,Huyện:  ${diachis.getHuyen()} ,Tỉnh:    ${diachis.getTinh()}
                                        </option>
                                    </c:forEach>
                                </select>
                                <p> <a href="/diachi?action=create">Thêm mới địa chỉ</a></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label >Trình độ:</label>
                            <select name="id_trinhdo">
                                <option value="${nhanvien.getTrinhdo().getId_trinhdo()}">
                                    ${nhanvien.getTrinhdo().getTen_trinhdo()}
                                </option>
                                <c:forEach items="${trinhdos}" var="trinhdo">
                                    <option value="${trinhdo.getId_trinhdo()}">
                                            ${trinhdo.getTen_trinhdo()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label >Bộ phận:</label>
                            <select name="id_bophan">
                                <option value="${nhanvien.getBophan().getId_bophan()}">
                                    ${nhanvien.getBophan().getTen_bophan()}
                                </option>
                                <c:forEach items="${bophans}" var="bophan">
                                    <option value="${bophan.getId_bophan()}">
                                            ${bophan.getTen_bophan()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label >Vị trí:</label>
                            <select name="id_vitri">
                                <option value="${nhanvien.getVitri().getId_vitri()}">
                                    ${nhanvien.getVitri().getTen_vitri()}
                                </option>
                                <c:forEach items="${vitris}" var="vitri">
                                    <option value="${vitri.getId_vitri()}">
                                            ${vitri.getTen_vitri()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label >User:</label>
                            <select name="ten_user">
                                <option value="${nhanvien.getUser().getTen_user()}">
                                    ${nhanvien.getUser().getTen_user()}
                                </option>
                                <c:forEach items="${users}" var="user">
                                    <option value="${user.getTen_user()}">
                                            ${user.getTen_user()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" name="submit" class="btn btn-primary">thêm mới</button>
                    </form>
                </div>
            </article>
        </div>
    </nav>
    <jsp:include page="/footer.jsp"/>
</div>
</body>


</body>
</html>
