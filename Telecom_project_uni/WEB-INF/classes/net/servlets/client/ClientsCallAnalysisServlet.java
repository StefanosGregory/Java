package net.servlets.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.ClientBean;
import net.queries.database.ClientsBillDao;


@WebServlet("/ClientsCallAnalysisServlet")
public class ClientsCallAnalysisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        HttpSession session = request.getSession();
        Object username1 = session.getAttribute("username"); 
        session.setAttribute("username",username1);
		PrintWriter out=response.getWriter();  
        String username = request.getParameter("username");
        out.print("<html>");
        out.print("<head>");
          out.print("<link rel='stylesheet' type='text/css' href='css/ClientsViewDelete.css'>");

        out.print("<title>Calls</title>");
        out.print("</head>");
        out.print("<body>");
		out.print("<ul>");
		out.print("  <li class='dropdown'>");
		out.print("    <a   href='ClientYourBillsServlet?username="+username+"'>Your Bills</a>");
		out.print("</li>");
		
		out.print("  <li>");
		out.print("  <a href='client_page.jsp'>Logout</a>");
		out.print("  </li>");
		out.print("</ul>");
          out.print("<br>");
          out.print("<br>");
        out.print("<form class='form1'>"); 
        out.print("<div class='container'>");
        out.println("<h1  class='register' >Your Calls ,</h1>");
        ClientsBillDao clientsBillDao = new ClientsBillDao();
        ClientBean ex = clientsBillDao.getPhoneNumberByUSername(username);
        List<ClientBean> list = clientsBillDao.getAllCall(ex.getPhoneNumber(),Integer.parseInt(request.getParameter("Month")));  
        out.print("<table>");  
        out.print("<tr><th>No.</th><th>Duration</th></tr>");  
        for(ClientBean e:list) {
        	out.print("<tr><td class='center'>"+e.getCall_id()+"</td><td class='center'>"+e.getCall_duration()+"</tr>");
        };
        out.print("</table>");
        out.print("<br>");
        out.print("</div>");
        out.print("</form>");
        out.close(); 

	}

}

