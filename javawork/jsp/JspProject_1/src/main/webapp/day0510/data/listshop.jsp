<%@ page import="data.Dao.ShopDao" %>
<%@ page import="data.Dto.ShopDto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: igahyeon
  Date: 2024/05/10
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //idx int 타입으로 읽기
    int idx=Integer.parseInt(request.getParameter("idx"));
    //dao
    ShopDao dao=new ShopDao();
    //list
    List<ShopDto> list=dao.getShopDatas(idx);

    //날짜 포맷
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //json으로 변환
    JSONArray arr=new JSONArray();
    for(ShopDto dto:list){
        JSONObject ob=new JSONObject();
        ob.put("shopidx",dto.getShopidx());
        ob.put("sname",dto.getSname());
        ob.put("sprice",dto.getSprice());
        ob.put("scount",dto.getScount());
        ob.put("scolor",dto.getScolor());
        ob.put("sphoto",dto.getSphoto());
        ob.put("writeday",sdf.format(dto.getWriteday()));

        arr.add(ob);
    }
%>
<%=arr.toString()%>
