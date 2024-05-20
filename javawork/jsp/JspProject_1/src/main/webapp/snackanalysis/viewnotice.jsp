<%@ page import="java.io.PrintWriter" %>
<%@ page import="bbs.BbsDao" %>
<%@ page import="bbs.BbsDto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Exo&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link rel="stylesheet" href="../snackanalysis/custom.css">
</head>
<body>
<%
    String userID = null;
    if (session.getAttribute("userID") != null) {
        userID = (String) session.getAttribute("userID");
    }
    int bbsID = 0;
    if (request.getParameter("bbsID") != null) {
        bbsID = Integer.parseInt(request.getParameter("bbsID"));
    }

    int pageNumber = 1;
    // pageNumber는 URL에서 가져온다.
    if (request.getParameter("pageNumber") != null) {
        pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
    }
    BbsDao bbsDAO = new BbsDao();
    BbsDto bbs = bbsDAO.getBbs(bbsID);
    bbsDAO.increasecount(bbsID);


    if (bbsID == 0) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('유효하지 않는 글입니다.')");
        script.println("location.href = 'list.jsp'");
        script.println("</script>");
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
<div class="container">
    <div class="row">
        <table class="table table-striped"
               style="text-align: center; border: 1px solid #dddddd">
            <thead>
            <tr>
                <th colspan="3"
                    style="background-color: #eeeeee; text-align: center;">게시판
                    글보기
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td style="width: 20%;">글제목</td>
                <td colspan="2">
                    <%=bbs.getBbsTitle()%>
                </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td colspan="2"><%=bbs.getUserID()%></td>
            </tr>
            <tr>
                <td>작성일자</td>
                <td colspan="2"><%=bbs.getBbsDate().substring(0, 11)%></td>
            </tr>
            <tr>
                <td>조회수</td>
                <td colspan="2"><%=bbs.getCount()%></td>
            </tr>
            <tr>
                <td>좋아요</td>
                <td colspan="2""><%=bbs.getLike_count()%></td>
            </tr>
            <tr>
                <td>내용</td>
                <td colspan="2" style="min-height: 200px; text-align: left;">
                    <%=bbs.getBbsContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>")%>
                </td>
            </tr>
            <tr>
                <td colspan="3" style="text-align: center;">
                    <a href="list.jsp" class="btn btn-primary">목록</a>
                    <% if (userID != null && userID.equals(bbs.getUserID())) { %>
                    <a href="update.jsp?bbsID=<%=bbsID%>" class="btn btn-primary">수정</a>
                    <a onclick="return confirm('정말로 삭제하시겠습니까?')" href="deleteAction.jsp?bbsID=<%=bbsID%>" class="btn btn-primary">삭제</a>
                    <% } %>
                    <form action="likeAction.jsp" method="post">
                        <input type="hidden" name="bbsID" value="<%=bbsID%>">
                        <button type="submit" class="btn btn-primary" id="likeButton" style="margin-top: 10px;">♥</button>
                    </form>
                </td>
            </tr>
            </tbody>

        </table>
    </div>
</div>


<script>
    document.querySelector('#likeButton').addEventListener('click', function () {
        if (this.classList.contains('liked')) {
            // 좋아요 취소
            this.classList.remove('liked');
            this.disabled = true;
            this.style.backgroundColor = '';
            // 좋아요 취소 요청을 서버에 전송
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'unlikeAction.jsp', true);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // 서버 응답이 성공적으로 완료될 경우 동작
                    // 여기에 추가 동작을 구현
                    // 예: 좋아요 수 업데이트, UI 변경 등
                    var newLikeCount = parseInt(xhr.responseText);
                    document.querySelector('#likeButton').innerHTML = '♥ ';
                    document.querySelector('#likeButton').disabled = false;
                    document.querySelector('#likeButton').classList.remove('liked'); // 좋아요 버튼 클래스 변경
                }
            };
            xhr.send('bbsID=<%=bbsID%>&cancel=true');
        } else {
            // 좋아요 추가
            this.classList.add('liked');
            this.disabled = true;
            this.style.backgroundColor = 'red';
            // 좋아요 추가 요청을 서버에 전송
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'likeAction.jsp', true);
            xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // 서버 응답이 성공적으로 완료될 경우 동작
                    // 여기에 추가 동작을 구현
                    // 예: 좋아요 수 업데이트, UI 변경 등
                    var newLikeCount = parseInt(xhr.responseText);
                    document.querySelector('#likeButton').innerHTML = '♡ ';
                    document.querySelector('#likeButton').disabled = false;
                    document.querySelector('#likeButton').classList.add('liked'); // 좋아요 버튼 클래스 변경
                }
            };
            xhr.send('bbsID=<%=bbsID%> &cancel=false');
        }
    });
</script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>