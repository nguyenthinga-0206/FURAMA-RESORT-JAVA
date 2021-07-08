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
    <title>Title</title>
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
    <nav>
        <div class="row">
            <div class="col-sm-2">
                <%
                    if (session.getAttribute("quyen").equals("Quản lý nhân viên") || session.getAttribute("quyen").equals("Giám đốc")) {
                %>
                <a class="nav-link" href="/nhanvien">Xem danh sách nhân viên</a>
                <a class="nav-link" href="/nhanvien?action=create">Thêm mới nhân viên</a>
                <%} %>
            </div>
            <div class="col-sm-10">
                <div class="tab-content">
                    <div class="container">
                        <h2>Danh sách Nhân viên</h2>
                        <table class="table table-hover" id="tablenhanvien">
                            <thead>
                            <tr>
                                <%--                        <th>Id</th>--%>
                                <th>Tên</th>
                                <%--                        <th>Ngày Sinh</th>--%>
                                <%--                        <th>Số Cmnd</th>--%>
                                <th>Số điện thoại</th>
                                <th>Email</th>
                                <th>Trình độ</th>
                                <th>Vị trí</th>
                                <th>Bộ phận</th>
                                <%--                        <th>Lương</th>--%>
                                <th>Địa chỉ</th>
                                <th>Tên_User</th>
                                <%
                                    if (session.getAttribute("quyen").equals("Quản lý nhân viên") || session.getAttribute("quyen").equals("Giám đốc")) {
                                %>
                                <th>Edit</th>
                                <th>Delete</th>
                                <%} %>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${nhanviens}" var="nhanvien">
                            <tr>
                                    <%--                        <td>${nhanvien.getId_nhanvien()}</td>--%>
                                <td>${nhanvien.getTen_nhanvien()}</td>
                                    <%--                        <td>${nhanvien.getNgaysinh()}</td>--%>
                                    <%--                        <td>${nhanvien.getSocmnd()}</td>--%>
                                <td>${nhanvien.getSdt()}</td>
                                <td>${nhanvien.getEmail()}</td>
                                <td>${nhanvien.getTrinhdo().getTen_trinhdo()}</td>
                                <td>${nhanvien.getVitri().getTen_vitri()}</td>
                                <td>${nhanvien.getBophan().getTen_bophan()}</td>
                                    <%--                        <td>${nhanvien.getLuong()}</td>--%>
                                <td>
                                    <a href="/diachi?action=view&id=${nhanvien.getDiachi().getId_diachi()}">
                                            ${nhanvien.getDiachi().getId_diachi()}
                                    </a>
                                </td>
                                <td>${nhanvien.getUser().getTen_user()}</td>
                                <%
                                    if (session.getAttribute("quyen").equals("Quản lý nhân viên") || session.getAttribute("quyen").equals("Giám đốc")) {
                                %>
                                <td>
                                    <a href="/nhanvien?action=edit&id=${nhanvien.getId_nhanvien()}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="#myModal_${nhanvien.getId_nhanvien()}" role="button"
                                       class="btn btn-large btn-danger"
                                       data-toggle="modal">Xoa</a>
                                </td>
                                <%} %>

                            </tr>
                            <div id="myModal_${nhanvien.getId_nhanvien()}" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                &times;
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Bạn có chắc chắn muốn xóa ${nhanvien.getId_nhanvien()} này ?</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Hủy
                                            </button>
                                            <a href="/nhanvien?action=delete&id=${nhanvien.getId_nhanvien()}"
                                               role="button" class="btn btn-danger" title="Xoa">Xóa</a>
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <%--        </article>--%>
            </div>
        </div>
    </nav>
    <jsp:include page="/footer.jsp"/>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tablenhanvien').dataTable(
            {
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 2
            }
        );
        $(".nav-tabs a").click(function () {
            $(this).tab('show');
        });
    })
</script>
</body>
</html>
