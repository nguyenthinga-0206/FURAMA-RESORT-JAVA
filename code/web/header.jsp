<%--
  Created by IntelliJ IDEA.
  User: nhu
  Date: 6/23/2021
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="row">
    <div class="col-sm-8 shopping-mall">
        <div  class="row">
            <div class="col-sm-3">
                <img class="avatar" src="img/anh1.jpg" width="60px" height="60px">
            </div>
            <div class="col-sm-9" style="padding:20px;color: #0d0d0d">
              <h6> <i>CHÀO MỪNG BẠN ĐẾN VỚI FURAMA RESORT ĐÀ NẴNG </i></h6>
            </div>

        </div>
    </div>
    <div>
    <%
        if(session.getAttribute("ten") != null){
    %>
    <h4>Tài Khoản: <strong><%=session.getAttribute("ten") %></strong> </h4>
    <%} %>
    <%
        if(session.getAttribute("quyen") != null){
    %>
        <h6><i>Quyền: <%=session.getAttribute("quyen") %></i></h6>
    <%} %>
    </div>
</header>