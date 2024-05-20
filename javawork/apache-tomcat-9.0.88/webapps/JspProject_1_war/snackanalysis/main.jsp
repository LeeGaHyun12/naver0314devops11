<%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/02
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
        <ul class="menu-list" style="display: flex; list-style: none; padding: 0; margin-top: 50px; margin-left: 100px; ">
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

<div style="position: relative; margin-left: 450px; margin-bottom: 20px;">
    <form action="search.jsp" method="get">
        <input type="text" id="search-input" name="keyword" placeholder="이곳에 궁금한 과자를 입력하세요 !" style="padding: 20px; border-radius: 20px; border: 7px solid #e8ab7f; font-size: 22px; width: 500px;">
        <input type="image" src="../image/검색과자.png" alt="검색" style="position: absolute; right: 15px; top: 50%; transform: translateY(-50%); width: 70%; cursor: pointer;">
    </form>
</div>

</div>
<div class="container" style="max-width: 40%; margin: 0 auto; border-radius: 20px;">
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="../image/먹태깡.PNG" class="d-block w-50 mx-auto" alt="이미지 1">
            </div>
            <div class="carousel-item">
                <img src="../image/감자깡.PNG" class="d-block w-50 mx-auto" alt="이미지 2">
            </div>
            <div class="carousel-item">
                <img src="../image/소금빵.PNG" class="d-block w-50 mx-auto" alt="이미지 3">
            </div>
            <div class="carousel-item">
                <img src="../image/인디안밥.PNG" class="d-block w-50 mx-auto" alt="이미지 4">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleSlidesOnly" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">이전</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleSlidesOnly" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">다음</span>
        </button>
    </div>
</div>
<script>
    $(document).ready(function(){
        // 자동으로 다음 슬라이드로 이동하는 함수
        function nextSlide() {
            $('.carousel').carousel('next');
        }

        // 3초마다 nextSlide 함수를 호출하여 슬라이드 전환
        setInterval(nextSlide, 3000);
    });
</script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<footer class="container-fluid" style="background-color: #9E9E9E; height: 100px; padding: 20px; position: fixed; bottom: 0; width: 100%;">
    <p>개인정보방침</p>
    <p>[31538]서울특별시 비트캠프| 우편사서함: 서울특별시 | TEL : 010-7582-2284 | FAX : 010-1234-2222</p>
</footer>
</body>
</html>
