<%@ page import="data.Dao.ShopDao" %>
<%@ page import="data.Dto.ShopDto" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //shopidx
    int shopidx=Integer.parseInt(request.getParameter("shopidx"));
    //dao
    ShopDao dao=new ShopDao();
    //dto
    ShopDto dto=dao.getSangpum(shopidx);

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //json
    JSONObject ob =new JSONObject();
    ob.put("shopidx",dto.getShopidx());
    ob.put("sname",dto.getSname());
    ob.put("sprice",dto.getSprice());
    ob.put("scount",dto.getScount());
    ob.put("scolor",dto.getScolor());
    ob.put("sphoto",dto.getSphoto());
    ob.put("writeday",sdf.format(dto.getWriteday()));

%>
<%=ob.toString()%>
