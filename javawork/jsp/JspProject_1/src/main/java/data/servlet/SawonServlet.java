package data.servlet;

import data.Dao.SawonDao;
import data.Dto.SawonDto;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/bitcamp/sawon")
public class SawonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SawonDao dao=new SawonDao();
        List<SawonDto> list=dao.getAllSawons();

        request.setAttribute("list",list);

        RequestDispatcher rd=request.getRequestDispatcher("../day0513/sawonlist.jsp");
        rd.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}