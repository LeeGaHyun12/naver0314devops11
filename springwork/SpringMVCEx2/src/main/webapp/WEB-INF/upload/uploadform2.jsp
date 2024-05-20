<%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/20
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
  <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
  <style>
    body *{
      font-family: 'Jua';
    }
  </style>
</head>
<body>
<h3>제목과 원하는 사진 여러 개 업로드하세요</h3>
<form action="./upload2" method="post" enctype="multipart/form-data"> <!--파일이 한개라도 들ㅇ어있으면 enctype무조건 해줘야 한-->
  <h4>제목을 입력해주세요</h4>
  <input type="text" name="title">
  <h4>사진 여러 장을 업로드 해주세요</h4>
  <input type="file" name="upload" multiple>
  <br>
  <button type="submit">제목과 사진 업로드</button>
</form>
</body>
</html>
