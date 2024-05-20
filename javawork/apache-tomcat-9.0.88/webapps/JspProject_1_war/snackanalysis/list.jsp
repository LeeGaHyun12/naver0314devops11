<%@ page import="java.io.PrintWriter"%>
<%@ page import="bbs.BbsDao"%>
<%@ page import="bbs.BbsDto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<body>
<%
    String userID =null;
    if(session.getAttribute("userID")!=null){
        userID = (String) session.getAttribute("userID");
    }
//    int pageNumber = 1;
//    if(request.getParameter("pageNumber")!=null){
//        pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
//    }
%>

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
            <table class="table table-striped"
                   style="text-align: center; border: 1px solid #dddddd">
                <thead>
                <tr>
                    <th style="background-color: #eeeeee; text-align: center;">번호</th>
                    <th style="background-color: #eeeeee; text-align: center;">제목</th>
                    <th style="background-color: #eeeeee; text-align: center;">작성자</th>
                    <th style="background-color: #eeeeee; text-align: center;">작성일</th>
                </tr>
                </thead>
                <tbody>
                <%
                    BbsDao bbsDao = new BbsDao();
                    List<BbsDto> list = bbsDao.Notice_getList();
                    for (int i = 0; i < list.size(); i++) {
                %>
                <tr>
                    <td><%=list.get(i).getBbsID()%></td>
                    <td><a href="viewnotice.jsp?bbsID=<%= list.get(i).getBbsID() %>">
                        <%= list.get(i).getBbsTitle() %></a></td>
                    <td><%= list.get(i).getUserID() %></td>
                    <td><%= list.get(i).getBbsDate() %></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
<%--            <%--%>
<%--                if (pageNumber != 1) {--%>
<%--            %>--%>
<%--            <a href="list.jsp?pageNumber=<%=pageNumber - 1%>"--%>
<%--               class="btn btn-success btn-arrow-left">이전</a>--%>
<%--            <%--%>
<%--                } if (bbsDAO.nextPage(pageNumber + 1)) {--%>
<%--            %>--%>
<%--            <a href="list.jsp?pageNumber=<%=pageNumber + 1%>"--%>
<%--               class="btn btn-success btn-arrow-left">다음</a>--%>
<%--            <%--%>
<%--                }--%>
<%--            %>--%>
            <a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

</body>
</html>