<%@ page import="data.Dao.ShopDao" %>
<%@ page import="data.Dto.ShopDto" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/04/29
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body *{
            font-family: 'Jua';
        }
    </style>
</head>

<%
    //shopidx int 타입으로 읽기
    int shopidx=Integer.parseInt(request.getParameter("shopidx"));
    //dao 선언
    ShopDao dao=new ShopDao();
    //dto 데이타 가져오기
    ShopDto dto=dao.getSangpum(shopidx);
    //날짜 포멧양식 지정
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div style="margin: 10px; width: 500px;">
    <h2><b>상품명: <%=dto.getSname()%></b></h2>
    <span style="font-size: 14px; color: gray;">
        등록일: <%=sdf.format(dto.getWriteday())%>
    </span>

    <table>
        <tr>
            <td width="300">
                <img src="<%=dto.getSphoto()%>"
                     style="border: 10px groove orange; margin: 10px; width: 270px;">
            </td>
            <td>
                <h5>가 격 : <%=dto.getSprice()%>원</h5>
                <h5 style="background-color: <%=dto.getScolor()%>">
                    색 상 : <%=dto.getScolor()%>
                </h5>
                <h5>수 량 : <%=dto.getScount() %>개</h5>
                <h5>총금액 : <%=dto.getScount()*dto.getSprice()%>원</h5>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px" onclick="location.href = 'shoplist.jsp'">목록</button>
                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px" onclick="location.href = 'shopupdateform.jsp?shopidx=<%=dto.getShopidx()%>'">수정</button>
                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px" onclick="location.href = 'shopdelete.jsp?shopidx=<%=dto.getShopidx()%>'">삭제</button>
                <button type="button" class="btn btn-outline-danger btn-sm"
                        style="width: 80px" onclick="location.href = 'shopform.jsp'">추가</button>

            </td>
        </tr>
    </table>
</div>
</body>
</html>
