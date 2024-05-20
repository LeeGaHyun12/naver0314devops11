<%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/06
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Exo&family=Single+Day&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="stylesheet" href="../snackanalysis/custom.css">
</head>
<%
    String userID = null;
    if (session.getAttribute("userID") != null) {
        userID = (String) session.getAttribute("userID");
    }
%>
<body>
<div style="background-color: #CC9966">
    <header class="d-flex">
        <a href="main.jsp"><img src="../image/메인제목.png" alt="전과자에 대하여" style="width: 300px;"></a>
        <ul class="menu-list" style="display: flex; list-style: none; padding: 0; margin-top: 50px; margin-left: 80px; ">
            <li style="margin-right: 10px; white-space: nowrap;">
                <a href="search.jsp" class="menu-item" style="text-decoration: none; color:  #eac476; font-weight: bold; text-shadow: 1px 1px 0px #8B4513;">🍪 과자 검색
                </a>
            </li>
            <li style="margin-right: 10px; white-space: nowrap;">
                <a href="snackinfo.jsp" class="menu-item" style="text-decoration: none; color:  #eac476; font-weight: bold; text-shadow: 1px 1px 0px #8B4513;">📊 과자 정보
                </a>
            </li>
            <li style="margin-right: 10px;white-space: nowrap;">
                <a href="list.jsp" class="menu-item" style="text-decoration: none; color:  #eac476; font-weight: bold; text-shadow: 1px 1px 0px #8B4513;">📝 정보게시판
                </a>
            </li>

        </ul>

        <div class="header-buttons">
            <%
                if(userID==null){
            %>
            <button type="button" class="btn btn-success"><a href="login.jsp" style="text-decoration: none; color: white;">로그인</a></button>
            <button type="button" class="btn btn-warning"><a href="join.jsp" style="text-decoration: none; color: white;">회원가입</a></button>
            <%
            } else{
            %>
             <button type="button" class="btn btn-danger"><a href="logoutaction.jsp" style="text-decoration: none; color: white;">로그아웃</a></button>

            <%
                }
            %>
        </div>
    </header>
    <hr>
</div>
<br>
<div class="container">
    <div class="row">
        <form method="post" action="writeaction.jsp">
            <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
                <thead>
                <tr>
                    <th colspan="2" style="background-color: #eeeeee; text-align: center;">과자 정보를 공유해주세요 !</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" class="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
                </tr>
                <tr>
                    <td><textarea class="form-control" placeholder="글 내용" name="bbsContent" maxlength="2048" style="height: 350px"></textarea></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" class="btn btn-primary pull-right" value="글쓰기">
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</body>
</html>
