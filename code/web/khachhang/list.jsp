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
    <nav >
        <div class="row container">
            <article class="col-sm-3">
                <%
                    if (session.getAttribute("quyen").equals("Quản lý khách hàng") || session.getAttribute("quyen").equals("Giám đốc")) {
                %>
                <a class="nav-link " href="/khachhang">Xem danh sách khách hàng</a>
                <a class="nav-link " href="/khachhang?action=create">Thêm mới khách hàng</a>
                <%} %>

            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <div>
                        <h2>Danh sách khách hàng</h2>
                        <table class="table table-hover" id="tableKhachhang">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Tên</th>
                                <th>Ngày Sinh</th>
                                <th>Giới Tính</th>
                                <th>Số Cmnd</th>
                                <th>Số điện thoại</th>
                                <th>Email</th>
                                <th>Loại Khách</th>
                                <th>Địa Chỉ</th>
                                <%
                                    if (session.getAttribute("quyen").equals("Quản lý khách hàng") || session.getAttribute("quyen").equals("Giám đốc")) {
                                %>
                                <th>Edit</th>
                                <th>Delete</th>
                                <%} %>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${khachhang}" var="khachhang">
                            <tr>
                                <td>${khachhang.getId_khachhang()}</td>
                                <td>${khachhang.getTen_khachhang()}</td>
                                <td>${khachhang.getNgaysinh()}</td>
                                <td>${khachhang.getGioitinh()}</td>
                                <td>${khachhang.getSocmnd()}</td>
                                <td>${khachhang.getSdt()}</td>
                                <td>${khachhang.getEmail()}</td>
                                <td>${khachhang.getLoaikhach().getTen_loaikhach()}</td>
                                <td>
                                    <a href="/diachi?action=view&id=${khachhang.getDiachi().getId_diachi()}">
                                            ${khachhang.getDiachi().getId_diachi()}
                                    </a>
                                </td>
                                    <%--            <td>${khachhang.getDiachi().getSonha()}</td>--%>
                                    <%--            <td>${khachhang.getDiachi().getXa()}</td>--%>
                                    <%--            <td>${khachhang.getDiachi().getHuyen()}</td>--%>
                                    <%--            <td>${khachhang.getDiachi().getTinh()}</td>--%>
                                    <%--            <td>${khachhang.getDiachi().getQuocgia()}</td>--%>
                                <%
                                    if (session.getAttribute("quyen").equals("Quản lý khách hàng") || session.getAttribute("quyen").equals("Giám đốc")) {
                                %>
                                <td>
                                    <a href="/khachhang?action=edit&id=${khachhang.getId_khachhang()}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="#myModal_${khachhang.getId_khachhang()}" role="button"
                                       class="btn btn-large btn-danger"
                                       data-toggle="modal">Xoa</a>
                                </td>
                                <%} %>

                            </tr>
                            <div id="myModal_${khachhang.getId_khachhang()}" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                &times;
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Bạn có chắc chắn muốn xóa ${khachhang.getId_khachhang()} này ?</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                                            <a href="/khachhang?action=delete&id=${khachhang.getId_khachhang()}"
                                               role="button" class="btn btn-danger" title="Xoa">Xóa</a>
                                        </div>
                                    </div>
                                </div>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </article>
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
        $('#tableKhachhang').dataTable(
            {
                "dom":'lrtip',
                "lengthChange": false,
                "pageLength": 2
            }
        );
        $(".nav-tabs a").click(function(){
            $(this).tab('show');
        });

    })


</script>
</body>
</html>
