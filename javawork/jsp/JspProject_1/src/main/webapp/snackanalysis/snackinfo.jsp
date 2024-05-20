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
        tr{
            background-color: #d07b4c;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #e8ab7f;
        }

        th {
            background-color: #343a40;
            color: #b69178;
        }

        tr:nth-child(even) {
            background-color: #eab68d;
        }

        tr:hover {
            background-color: #e0b89a;
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
                <a href="snackinfo.jsp" class="menu-item"
                   style="text-decoration: none; color:  #eac476; font-weight: bold; text-shadow: 1px 1px 0px #8B4513;">📊
                    과자 정보
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
            <button type="button" class="btn btn-success"><a href="login.jsp" style="text-decoration: none; color: white;">로그인</a>
            </button>
            <button type="button" class="btn btn-warning"><a href="join.jsp" style="text-decoration: none; color: white;">회원가입</a>
            </button>
            <%
            } else {
            %>
            <button type="button" class="btn btn-danger"><a href="logoutaction.jsp" style="text-decoration: none; color: white;">로그아웃</a>
            </button>
    </header>

                <%
    if (session.getAttribute("userID") != null) {
        userID = (String) session.getAttribute("userID");
    }
%>
<div>
            <h1>과자 리스트</h1>
            <table>
                <thead>
                <tr>
                    <th>과자 코드</th>
                    <th>과자 이름</th>
                    <th>제조사</th>
                </tr>
                </thead>
                <tbody>
                <%
                    SnackDao snackDao = new SnackDao();
                    List<SnackDto> snacks = snackDao.getAllSnacks();
                    for (SnackDto snack : snacks) {
                %>
                <tr>
                    <td><%= snack.getFood_cd() %></td>
                    <td><%= snack.getFood_nm() %></td>
                    <td><%= snack.getMfr_nm() %></td>
                </tr>
                <% } %>
                </tbody>
            </table>
            </html>

            <%
                }
            %>
        </div>

    <hr>
</div>
</html>
