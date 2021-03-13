package net.servlets.seller;

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



@WebServlet("/ClientsBillServlet2")
public class ClientsBillServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.print("<link rel='stylesheet' type='text/css' href='css/seller_edit_client.css'>");
	        String phone = request.getParameter("PhoneNumber"); 
	        HttpSession session = request.getSession();
	         Object username = session.getAttribute("username"); 
	         session.setAttribute("username",username);
	        int month= Integer.parseInt(request.getParameter("Month")); 
	          
	        ClientBean e=new ClientBean();  
	        e.setPhoneNumber(phone);
	        e.setMonthBill(month);
	        ClientsBillDao clientsBillDao = new ClientsBillDao();
	        int status=clientsBillDao.pay(e);  
	        if(status>0){  
	            response.sendRedirect("ClientsViewBillsServlet");  
	        }else{  
	        	out.print("<div class='alert'>");
	  	        out.print("<form action='ClientsViewBillsServlet'>Error, try again later!<input type='submit' class='closebtn' value='X'/></form>");  
	        	out.print("</div>");
	        }  
	          
	        out.close();  
	    }  

}

