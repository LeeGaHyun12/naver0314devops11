<%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/10
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="data.Dao.ShopDao"/>
<jsp:useBean id="dto" class="data.Dto.ShopDto"/>
<jsp:setProperty name="dto" property="*"/><!--이름이 같은 데이터를 dto에 넣음 name하고 dto에 있는 이름이 같아야 함-->
<%
    dao.insertShop(dto);
%>
