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


@WebServlet("/ClientYourBillsServlet")
public class ClientYourBillsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter(); 
        HttpSession session = request.getSession();
        Object username1 = session.getAttribute("username"); 
        session.setAttribute("username",username1);
        out.print("<html>");
        out.print("<head>");
          out.print("<link rel='stylesheet' type='text/css' href='css/ClientYourBill.css'>");

        out.print("<title>Bill</title>");
        out.print("</head>");
        out.print("<body>");

			out.print("<ul>");
			out.print("  <li class='dropdown1'>");
			out.print("    <a   class='down'>Your Bills</a>");
			out.print("</li>");
			
	        out.print("<li>"); 
	        out.print("<a href='login.jsp'>Logout</a>");
	        out.print("</li>");
			out.print("</ul>");
          out.print("<br>");
          out.print("<br>");
        out.print("<form class='form1'>"); 
        out.print("<div class='container'>");
        out.println("<h1  class='register' >Your Bills </h1>");
        String username = request.getParameter("username");
        ClientsBillDao clientsBillDao = new ClientsBillDao();
        ClientBean ex = clientsBillDao.getPhoneNumberByUSername(username);
        List<ClientBean> list = clientsBillDao.getAllStatus(ex.getPhoneNumber());  
        out.print("<table>");  
        out.print("<tr><th>Month</th><th>Status</th><th>Analysis</th><th>Pay</th></tr>");  
        for(ClientBean e:list) {
        	out.print("<tr><td class='center'>"+e.getMonthBill()+"</td><td class='center'>"+e.getStatus()+"</td><td class='center'><a class='center' href='ClientsCallAnalysisServlet?username="+username+"&Month="+e.getMonthBill()+"'> <img class='image' src='icons/view.png'></a></td><td class='center'><a class='center' href='ClientYourBillsServlet2?username="+username+"&Month="+e.getMonthBill()+"'> <img class='image' src='icons/paynow.png'></a></td></tr>");
        }
        out.print("</table>");
        out.print("<br>");
        out.print("</div>");
        out.print("</form>");
       
        out.close(); 

	}

}

