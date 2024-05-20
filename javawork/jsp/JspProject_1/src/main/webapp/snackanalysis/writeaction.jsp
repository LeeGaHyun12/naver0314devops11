<%@ page import="java.io.PrintWriter" %>
<%@ page import="bbs.BbsDto" %>
<%@ page import="bbs.BbsDao" %><%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/06
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="bbs" class="bbs.BbsDto" scope="page" />
<jsp:setProperty name="bbs" property="bbsTitle" />
<jsp:setProperty name="bbs" property="bbsContent" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userID = null;
    if (session.getAttribute("userID") != null) {
        userID = (String) session.getAttribute("userID");
    }
    if (userID == null) {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('로그인을 하세요.')");
        script.println("location.href = 'login.jsp'");
        script.println("history.back()");
        script.println("</script>");
    } else {
        if (bbs.getBbsTitle() == null || bbs.getBbsContent() == null) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('입력이 안된 사항이 있습니다.')");
            script.println("history.back()");
            script.println("</script>");
        } else {
            BbsDao bbsDAO = new BbsDao();
            bbsDAO.write(bbs.getBbsTitle(), userID, bbs.getBbsContent());
            response.sendRedirect("list.jsp");
//            if (result == -1) {
//                PrintWriter script = response.getWriter();
//                script.println("<script>");
//                script.println("alert('글쓰기에 실패 했습니다.')");
//                script.println("history.back()");
//                script.println("</script>");
//            } else {
//                PrintWriter script = response.getWriter();
//                script.println("<script>");
//                script.println("location.href = 'list.jsp'");
//                script.println("</script>");
//            }
        }
    }
%>
</body>
</html>
