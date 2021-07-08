<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/23/2021
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav >
    <div class="row">
            <div class="tab-content">
                <div id="nhanvien" class="container tab-pane fade"><br>
                    <div class="nav nav-tabs">
                        <ul class="nav nav-tabs mr-auto">
                            <li class="nav-item">
                                <a class="nav-link " href="/nhanvien?action=list.jsp">Xem danh sách nhân viên</a>
                                <a class="nav-link " href="/nhanvien?action=create.jsp">Thêm mới nhân viên</a>
                                <a class="nav-link " href="/nhanvien?action=edit.jsp">Sửa thông tin nhân viên</a>
                                <a class="nav-link " href="/nhanvien?action=search.jsp">Xóa nhân viên</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div id="khachhang" class="container tab-pane fade"><br>
                    <ul class="nav nav-tabs mr-auto">
                        <li class="nav-item">
                            <a class="nav-link " href="/khachhang?action=list.jsp">Xem danh sách khách hàng</a>
                            <a class="nav-link" href="/khachhang?action=list.jsp">Thêm mới khách hàng</a>
                            <a class="nav-link " href="#suakhachhang">Sửa thông tin khách hàng</a>
                            <a class="nav-link " href="#xoakhachhang">Xóa khách hàng</a>
                        </li>
                    </ul>
                </div>
                <div id="dichvu" class="container tab-pane fade"><br>
                    <ul class="nav nav-tabs mr-auto">
                        <li class="nav-item">
                            <a class="nav-link " href="#xemdichvu">Xem danh sách dịch vụ</a>
                            <a class="nav-link " href="#themdichvu">Thêm mới dịch vụ</a>
                            <a class="nav-link " href="#suadichvu">Sửa thông tin dịch vụ</a>
                            <a class="nav-link " href="#xoadichvu">Xóa dịch vụ</a>
                        </li>
                    </ul>
                </div>
                <div id="hopdong" class="container tab-pane active"><br>
                    <ul class="nav nav-tabs mr-auto">
                        <li class="nav-item">
                            <a class="nav-link " href="#xemhopdong">Xem danh sách hợp đồng</a>
                            <a class="nav-link" href="#themhopdong">Thêm mới hợp đồng</a>
                            <a class="nav-link " href="#suahopdong">Sửa thông tin hợp đồng</a>
                            <a class="nav-link " href="#xoahopdong">Xóa hợp đồng</a>
                        </li>
                    </ul>
                </div>
            </div>
    </div>
</nav>

