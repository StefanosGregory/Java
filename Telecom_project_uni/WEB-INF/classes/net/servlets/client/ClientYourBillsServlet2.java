package net.servlets.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.ClientBean;
import net.queries.database.ClientsBillDao;


@WebServlet("/ClientYourBillsServlet2")
public class ClientYourBillsServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username1 = session.getAttribute("username"); 
        session.setAttribute("username",username1);  
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.print("<link rel='stylesheet' type='text/css' href='css/seller_edit_client.css'>");
	        String username = request.getParameter("username");
	        int month= Integer.parseInt(request.getParameter("Month")); 
	        ClientsBillDao clientsBillDao = new ClientsBillDao();

	        ClientBean ex = clientsBillDao.getPhoneNumberByUSername(username);
	        ClientBean e=new ClientBean();
	        e.setMonthBill(month);
	        e.setPhoneNumber(ex.getPhoneNumber());
	        int status=clientsBillDao.pay(e);  
	        if(status>0){  
	            response.sendRedirect("ClientYourBillsServlet?username="+username+"");  
	        }else{  
	        	out.print("<div class='alert'>");
	  	        out.print("<form action='ClientYourBillsServlet?username="+username+"'>Error, try again later!<input type='submit' class='closebtn' value='X'/></form>");  
	        	out.print("</div>");
	        }  
	          
	        out.close();  
	    }  

}

