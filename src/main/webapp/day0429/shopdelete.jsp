<%@ page import="data.Dao.ShopDao" %>
<%@ page import="data.Dto.ShopDto" %><%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/04/29
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    try {
        //shopidx int 타입으로 읽기
        int shopidx = Integer.parseInt(request.getParameter("shopidx"));
        //dao 선언
        ShopDao dao = new ShopDao();

        //delete메서드 호출
        ShopDto dto = dao.getSangpum(shopidx);
        dao.deleteShop(dto);

        //목록 shoplist.jsp로 이동
        response.sendRedirect("shoplist.jsp");//이동,url 주소 바뀜
    }catch (Exception e){
        e.printStackTrace();
    }

%>
