<%@ page import="data.Dto.ShopDto" %>
<%@ page import="data.Dao.ShopDao" %><%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/04/29
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1. 엔코딩
    request.setCharacterEncoding("utf-8");
    //2.6개의 상품데이타
    String sname=request.getParameter("sname");
    String scolor=request.getParameter("scolor");
    String sphoto=request.getParameter("sphoto");
    int sprice=Integer.parseInt(request.getParameter("sprice"));
    int scount=Integer.parseInt(request.getParameter("scount"));
    String shopidx=request.getParameter("shopidx");

    //3. dto 에 넣기 -setter로 넣기(총 6개)
    ShopDto dto=new ShopDto(sname,sprice,scount,scolor,sphoto);

    //4. dao 선언
    ShopDao dao=new ShopDao();

    //5. insert 메서드 호출
    dao.insertShop(dto);

    //6.update 메서드 호출
    dao.updateShop(dto);

    //6. shoplist.jsp 로 이동
    response.sendRedirect("shoplist.jsp");//이동,url 주소 바뀜
%>
