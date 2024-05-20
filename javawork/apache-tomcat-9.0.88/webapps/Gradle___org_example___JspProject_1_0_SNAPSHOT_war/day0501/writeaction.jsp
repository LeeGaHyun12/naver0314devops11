<%@ page import="data.Dto.StudentDto" %>
<%@ page import="data.Dao.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/01
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //한글로 엔코딩
    request.setCharacterEncoding("utf-8");
    //데이터 읽기
    String name=request.getParameter("name");
    String blood=request.getParameter("blood");
    int java=Integer.parseInt(request.getParameter("java"));
    int spring=Integer.parseInt(request.getParameter("spring"));
    int html=Integer.parseInt(request.getParameter("html"));
    char license=request.getParameter("license")==null?'n':'y';

    //dto 선언 후 데이터 넣기
    StudentDto dto=new StudentDto();
    dto.setName(name);
    dto.setBlood(blood);
    dto.setJava(java);
    dto.setSpring(spring);
    dto.setHtml(html);
    dto.setLicense(license);

    //dao 선언 후 메서드 호출
    StudentDao dao=new StudentDao();
    dao.insertStudent(dto);
    //목록으로 이동
    response.sendRedirect("list.jsp");
%>

