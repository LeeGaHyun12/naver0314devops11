<%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/02
  Time: 5:20 PM
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

<body>
<%
    String userID =null;
    if(session.getAttribute("userID")!=null){
        userID = (String) session.getAttribute("userID");
    }
%>
<div style="background-color: #CC9966">
    <header class="d-flex">
        <a href="main.jsp"><img src="../image/메인제목.png" alt="전과자에 대하여" style="width: 300px;"></a>
        <div class="header-buttons">
            <%
                if(userID==null){
            %>
            <button type="button" class="btn btn-success"><a href="login.jsp" style="text-decoration: none; color: white;">로그인</a></button>
            <button type="button" class="btn btn-warning"><a href="join.jsp" style="text-decoration: none; color: white;">회원가입</a></button>
            <%
            } else{
            %>
            <button type="button" class="btn btn-info"><a href="mypage.jsp" style="text-decoration: none; color: white;">마이페이지</a></button>
            <button type="button" class="btn btn-danger"><a href="logoutaction.jsp" style="text-decoration: none; color: white;">로그아웃</a></button>

            <%
                }
            %>
        </div>
    </header>
    <hr>
</div>

<div id="content" style="height: 400px;">
    <h1><b>로그인</b></h1>
    <form action="./loginaction.jsp">
        <input type="text" name="userID" id="userID" class="login_input_text" placeholder="ID"><br>
        <input type="password" name="userPassword" id="userPassword" class="login_input_text" placeholder="Password"><br>
        <input type="submit" class="login_input_btn" value="Login">

    </form>
    <hr>
    <a href="join.jsp">회원가입</a>
    <div class="find_info"><br>
        <a id="find_id" href="#">아이디 찾기</a><a> |</a>
        <a id="find_password" href="#">비밀번호 찾기</a><br><br>
        <a class="sub_font_style" href="#"><b style="color:#7b7b7b">개인정보처리방침</b></a><br>
    </div>
</div>
</body>
</html>
