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
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: 'Exo', 'Jua';
        }

        html,
        body {
            height: 100%;
        }

        body {
            background-color: #996633;
        }

        a {
            text-decoration: none;
        }

        #content {
            position: relative;
            top: calc(50vh - 270px);
            width: 500px;
            height: 500px;
            background-color: rgba(255, 255, 255, 0.5);

            border-radius: 20px;
            border: solid 1px rgba(0, 0, 0, 0.08);
            box-shadow: 0 0 50px 0 rgba(0, 0, 0, 0.04);
            margin: 0 auto;

            text-align: center;

        }

        .logo *{
            margin: 50px 0px;
            width: 135px;
        }

        .join_input_text *{
            width: 330px;
            height: 50px;
            border-radius: 11px;
            border: solid 1px #dfdfdf;
            background: #fff;
            margin-top: -5px;
            margin-bottom: 15px;
            padding: 15px;
            box-sizing: border-box;
            font-size: 16px;
        }

        .join_input_text placeholder {
            color: #c6c6c6;

        }

        .join_input_btn *{
            width: 330px;
            height: 50px;
            border-radius: 11px;
            background-color: #995544;
            font-weight: bold;
            border: none;
            color: white;
            font-size: 16px;
            cursor: pointer;

        }

        .join_input_btn hover {
            background-color: #995533;

        }

        .personal_info a {
            font-size: 14px;
            font-family: 'Noto Sans KR', sans-serif;
            color: #bebebe;
            line-height: 25px;
        }

        .personal_info a:hover {
            color: #995544;
        }

        #copyright {
            position: absolute;
            bottom: -50px;
            width: 100%;
            font-size: 14px;
            color: #9f9f9f;
            font-family: 'Noto Sans KR', sans-serif;
        }

        @media screen and (max-width: 768px) {
            #content {
                width: 100%;
                height: auto;
                background-color: rgba(255, 255, 255, 0);
                border: none;
                box-shadow: none;

            }

            .join_input_text, .join_input_btn {
                width: 80%;

            }
        }
        .header-buttons {
            margin-top: auto;
            margin-left: auto;
            margin-right: 20px;
            font-family: Jua;
        }
    </style>
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
<div id="content">
    <h1><b>마이페이지</b></h1>

    <form method="post" style="padding-top: 20px;">
        <h5>아이디</h5>
        <input type="text" name="userID" class="join_input" placeholder="ID"><br>
        <h5>사용할 비밀번호</h5>
        <input type="password" name="userPassword" class="join_input" placeholder="Password"><br>
        <h5>이름</h5>
        <input type="text" name="userName" class="join_input" placeholder="이름"><br>
        <h5>성별</h5>
        <input type="radio" name="userGender" class="join_input" value="남자" checked="checked"> 남
        <input type="radio" name="userGender" class="join_input" value="여자"> 여
        <h5>이메일</h5>
        <input type="email" name="userEmail" class="join_input" placeholder="이메일"><br>
        <h2></h2>
        <input type="submit" class="Join_input_btn" value="회원가입">
    </form>
    <hr>
    <div class="personal_info"><br>
        <a class="sub_font_style" href="#"><b style="color:#7b7b7b">개인정보처리방침</b></a><br>
    </div>
</div>
</body>
</html>
