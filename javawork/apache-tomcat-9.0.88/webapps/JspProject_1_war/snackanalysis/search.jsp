<%@ page import="java.sql.*" %>
<%@ page import="snack.SnackDto" %>
<%@ page import="db.common.MySqlConnect" %>
<%@ page import="snack.SnackDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/02
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Exo&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="stylesheet" href="../snackanalysis/custom.css">
    <style>

        table {
            width: 100%;
            border-collapse: collapse;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 0 20px rgb(227, 178, 28);
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #dee2e6;
            background-color: white;
        }

        th {
            background-color: #343a40;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f8f9fa;
        }

        tr:hover {
            background-color: #e2e6ea;
        }

    </style>
</head>
<body>
<%
    String userID = null;
    if (session.getAttribute("userID") != null) {
        userID = (String) session.getAttribute("userID");
    }
%>
<div style="background-color: #CC9966">
    <header class="d-flex">
        <a href="main.jsp"><img src="../image/메인제목.png" alt="전과자에 대하여" style="width: 300px;"></a>
        <ul class="menu-list"
            style="display: flex; list-style: none; padding: 0; margin-top: 50px; margin-left: 80px; ">
            <li style="margin-right: 10px; white-space: nowrap;">
                <a href="search.jsp" class="menu-item"
                   style="text-decoration: none; color:  #eac476; font-weight: bold; text-shadow: 1px 1px 0px #8B4513;">🍪
                    과자 검색
                </a>
            </li>
            <li style="margin-right: 10px; white-space: nowrap;">
                <a href="snackinfo.jsp" class="menu-item" style="text-decoration: none; color:  #eac476; font-weight: bold; text-shadow: 1px 1px 0px #8B4513;">📊 과자 정보
                </a>
            </li>
            <li style="margin-right: 10px;white-space: nowrap;">
                <a href="list.jsp" class="menu-item"
                   style="text-decoration: none; color:  #eac476; font-weight: bold; text-shadow: 1px 1px 0px #8B4513;">📝
                    정보게시판
                </a>
            </li>
        </ul>

        <div class="header-buttons">
            <%
                if (userID == null) {
            %>
            <button type="button" class="btn btn-success"><a href="login.jsp"
                                                             style="text-decoration: none; color: white;">로그인</a>
            </button>
            <button type="button" class="btn btn-warning"><a href="join.jsp"
                                                             style="text-decoration: none; color: white;">회원가입</a>
            </button>
            <%
            } else {
            %>
            <button type="button" class="btn btn-danger"><a href="logoutaction.jsp"
                                                            style="text-decoration: none; color: white;">로그아웃</a>
            </button>

            <%
                }
            %>
        </div>
    </header>
    <hr>
</div>
<div style="position: relative; margin-left: 450px; margin-bottom: 20px;">
    <form action="search.jsp" method="get">
        <input type="text" id="search-input" name="keyword" placeholder="이곳에 궁금한 과자를 입력하세요 !"
               style="padding: 20px; border-radius: 20px; border: 7px solid #e8ab7f; font-size: 22px; width: 500px;">
        <input type="image" src="../image/검색과자.png" alt="검색"
               style="position: absolute; right: 15px; top: 50%; transform: translateY(-50%); width: 70%; cursor: pointer;">
    </form>
</div>

<%
    String keyword = request.getParameter("keyword");
    SnackDao snackDao = new SnackDao();
    SnackDto snackDto = snackDao.searchSnacks(keyword);
    if (snackDto != null) {
%>

<table border="1">
    <tr>
        <td colspan="11">
            <img src="../image/<%=keyword%>.png" style="margin-left:500px; width: 400px; height: 200px;">
        </td>
    </tr>
    <tr>
        <th> 과자 이름</th>
        <th> 칼로리</th>
        <th> 단백질</th>
        <th> 탄수화물</th>
        <th> 당류</th>
        <th> 식이섬유</th>
        <th> 칼슘</th>
        <th> 나트륨</th>
        <th> 콜레스테롤</th>
        <th> 1회 제공량</th>
        <th> 영양성분 제공처</th>
    </tr>

    <tr>
        <td><%=snackDto.getFood_nm()%>
        </td>
        <td><%=snackDto.getKcal()%>kcal
        </td>
        <td><%=snackDto.getProt()%>g
        </td>
        <td><%=snackDto.getTansu()%>g
        </td>
        <td><%=snackDto.getSugar()%>%
        </td>
        <td><%=snackDto.getSicke()%>g
        </td>
        <td><%=snackDto.getCa()%>g
        </td>
        <td><%=snackDto.getNat()%>g
        </td>
        <td><%=snackDto.getChole()%>g
        </td>
        <td><%=snackDto.getServ_size()%>g
        </td>
        <td><%=snackDto.getMfr_nm()%>
        </td>
    </tr>
    <%

    } else {
    %>
    <%
        }
    %>
</table>
</body>
</html>

