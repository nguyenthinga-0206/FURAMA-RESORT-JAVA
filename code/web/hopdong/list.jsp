<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/21/2021
  Time: 2:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách hợp đồng</title>
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
                    if (session.getAttribute("quyen").equals("Quản lý hợp đồng") || session.getAttribute("quyen").equals("Giám đốc")) {
                %>
                <a class="nav-link " href="/hopdong">Xem danh sách hợp đồng</a>
                <a class="nav-link " href="/hopdong?action=create">Thêm mới hợp đồng</a>
                <%} %>

            </article>
            <article class="col-sm-9">
                <div class="tab-content">
                    <div>
                        <h2>Danh sách hợp đồng</h2>
                        <table class="table table-hover" id="tableHopdong">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Ngày bắt đầu</th>
                                    <th>Ngày kết thúc</th>
                                    <th>tiền cược</th>
                                    <th>Tổng thanh toán</th>
                                    <th>Nhân viên</th>
                                    <th>Khách hàng</th>
                                    <th>Dịch vụ</th>
                                    <%
                                        if (session.getAttribute("quyen").equals("Quản lý hợp đồng") || session.getAttribute("quyen").equals("Giám đốc")) {
                                    %>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                    <%} %>

                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${hopdong}" var="hopdong">
                            <tr>
                                <td>${hopdong.getId_hopdong()}</td>
                                <td>${hopdong.getNgaybatdau()}</td>
                                <td>${hopdong.getNgayketthuc()}</td>
                                <td>${hopdong.getSotiendatco()}</td>
                                <td>${hopdong.getTongsotienthanhtoan()}</td>
                                <td>
                                    <a href="/nhanvien?action=view&id=${hopdong.getNhanvien().getId_nhanvien()}">
                                            ${hopdong.getNhanvien().getTen_nhanvien()}
                                    </a>
                                </td>
                                <td>
                                    <a href="/khachhang?action=view&id=${hopdong.getKhachhang().getId_khachhang()}">
                                            <%--                            ${hopdong.getKhachhang().getTen_khachhang()} kh--%>
                                            ${hopdong.getKhachhang().getTen_khachhang()}
                                    </a>
                                </td>
                                <td>
                                    <a href="/dichvu?action=view&id=${hopdong.getDichvu().getId_dichvu()}">
                                            ${hopdong.getDichvu().getTen_dichvu()}
                                    </a>
                                </td>
                                <%
                                    if (session.getAttribute("quyen").equals("Quản lý hợp đồng") || session.getAttribute("quyen").equals("Giám đốc")) {
                                %>
                                <td>
                                    <a href="/hopdong?action=edit&id=${hopdong.getId_hopdong()}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="#myModal_${hopdong.getId_hopdong()}" role="button" class="btn btn-large btn-danger"
                                       data-toggle="modal">Xoa</a>
                                </td>
                                <%} %>
                            </tr>
                            <div id="myModal_${hopdong.getId_hopdong()}" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                &times;
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Bạn có chắc chắn muốn xóa  ${hopdong.getId_hopdong()} này ?</p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
                                            <a href="/hopdong?action=delete&id=${hopdong.getId_hopdong()}"
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableHopdong').dataTable(
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
