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
    <title>Thêm mới khách hàng</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .invalid{
            color: brown;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="/header.jsp"/>
    <jsp:include page="/menu.jsp"/>
    <nav>
        <div class="row container">
            <article class="col-sm-3">
                            <a class="nav-link " href="/nhanvien">Xem danh sách nhân viên</a>
                            <a class="nav-link " href="/nhanvien?action=create">Thêm mới nhân viên</a>
           </article>
        <article class="col-sm-9">
            <div class="container">
                <form method="post" id="create" class="form" >
                    <div class="form-group ">
                        <label for="id" class="form-lable">Id</label>
                        <input type="text" name="id" class="form-control"  id="id"  placeholder="id">
                        <c:if test="${message_id != null}">
                            <span style="color: brown"> ${message_id} </span>
                        </c:if>
                    </div>

                    <div class="form-group">
                        <label class="form-lable">Tên</label>
                        <input type="text" name="ten" class="form-control" id="ten"  placeholder="ten">
<%--                        <span class="form-message">  </span>--%>
                    </div>
                    <div class="form-group">
                        <label >Ngày sinh:</label>
                        <input type="text"  name="ngaysinh" class="form-control" id="ngay"  placeholder="Ngày sinh 1999/12/03">
                        <c:if test="${message_ngaysinh != null}">
                            <span style="color: brown"> ${message_ngaysinh} </span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label >Số CMND:</label>
                        <input type="text"  name="socmnd" class="form-control" id="cmnd"  placeholder="cmnd">
                        <c:if test="${message_socmnd != null}">
                            <span style="color: brown"> ${message_socmnd} </span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label >Số đt:</label>
                        <input type="text"  name="sdt" class="form-control"  id="sdt" placeholder="sdt">
                        <c:if test="${message_sdt != null}">
                            <span style="color: brown"> ${message_sdt} </span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label  class="form-lable" >Email:</label>
                        <input type="text"  name="email" class="form-control" id="email"  placeholder="email">
                        <c:if test="${message_email != null}">
                            <span style="color: brown"> ${message_email} </span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label >Luong:</label>
                        <input type="text"  name="luong" class="form-control"  id="luong" placeholder="luong">
<%--                        <span class="form-message">  </span>--%>
                    </div>
                    <div class="form-group">
                        <label >Địa chỉ:</label>
                        <div>
                            <select name="id_diachi" id="diachi">
                                <option>
                                    Địa chỉ
                                </option>
                                <c:forEach items="${diachis}" var="diachis">
                                    <option value="${diachis.getId_diachi()}" ${diachis.getId_diachi()==id_diachi?"selected":""}>
                                        Số nhà :${diachis.getSonha()}  ,Xã: ${diachis.getXa()} ,Huyện:  ${diachis.getHuyen()} ,Tỉnh:    ${diachis.getTinh()}
                                    </option>
                                </c:forEach>
                            </select>
                            <p> <a href="/diachi?action=createnv">Thêm mới địa chỉ</a></p>
                        </div>
                        <span class="form-message">  </span>
                    </div>
                    <div class="form-group">
                        <label >Trình độ:</label>
                        <select name="id_trinhdo" id="trinhdo">
                            <option>
                                Trình độ
                            </option>
                            <c:forEach items="${trinhdos}" var="trinhdo">
                                <option value="${trinhdo.getId_trinhdo()}">
                                        ${trinhdo.getTen_trinhdo()}
                                </option>
                            </c:forEach>
                        </select>
                        <span class="form-message">  </span>
                    </div>
                    <div class="form-group">
                        <label >Bộ phận:</label>
                        <select name="id_bophan" id="bophan">
                            <option>
                                Bộ phận
                            </option>
                            <c:forEach items="${bophans}" var="bophan">
                                <option value="${bophan.getId_bophan()}">
                                        ${bophan.getTen_bophan()}
                                </option>
                            </c:forEach>
                        </select>
                        <span class="form-message">  </span>
                    </div>
                    <div class="form-group">
                        <label >Vị trí:</label>
                        <select name="id_vitri" id="vitri">
                            <option>
                                Vị trí
                            </option>
                            <c:forEach items="${vitris}" var="vitri">
                                <option value="${vitri.getId_vitri()}">
                                        ${vitri.getId_vitri()}
                                </option>
                            </c:forEach>
                        </select>
                        <span class="form-message">  </span>
                    </div>
                    <div class="form-group">
                        <label >User:</label>
                        <select name="ten_user" id="user">
                            <option>
                                ten_user
                            </option>
                            <c:forEach items="${users}" var="user">
                                <option value="${user.getTen_user()}">
                                        ${user.getTen_user()}
                                </option>
                            </c:forEach>
                        </select>
                        <span class="form-message">  </span>
                    </div>
                    <button type="submit" name="submit" class="btn btn-primary">thêm mới</button>
                </form>
            </div>
            <script src="/vadidate.js"></script>
            <script>
                Validate({
                    form: '#create',
                    rules:[
                        Validate.isID_NV('#id'),
                        Validate.isTen('#ten'),
                        Validate.isEmail('#email'),
                        Validate.isSDT('#sdt'),
                        Validate.isLuong('#luong'),
                        Validate.isSCMND('#cmnd'),
                        Validate.isNgay('#ngay'),
                    ]
                });
            </script>

        </article>
    </div>
</nav>
    <jsp:include page="/footer.jsp"/>
</div>
</body>
</html>
