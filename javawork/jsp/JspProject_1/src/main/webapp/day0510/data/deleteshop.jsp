<%@ page import="data.Dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/10
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //shopidx
    int shopidx=Integer.parseInt(request.getParameter("shopidx"));
    //dao
    ShopDao dao=new ShopDao();

    dao.deleteShop(shopidx);
%>
