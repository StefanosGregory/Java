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
import net.queries.database.DeleteClientDao;


@WebServlet("/DeleteClientServlet")
public class DeleteClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username1 = session.getAttribute("username"); 
        session.setAttribute("username",username1);  
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.print("<link rel='stylesheet' type='text/css' href='css/ClientsViewDelete.css'>");
	        String username = request.getParameter("username");
	        String phoneNumber =request.getParameter("PhoneNumber");  
	        ClientBean e=new ClientBean();  
	        e.setUsername(username);
	        e.setPhoneNumber(phoneNumber);
	        DeleteClientDao deleteClientDao = new DeleteClientDao();
	        int status=deleteClientDao.delete(e);
	        if(status>0){  
	            response.sendRedirect("ClientsViewDeleteServlet");  
	        }else{  
	        	out.print("<div class='alert'>");
	  	        out.print("<form action='ClientsViewDeleteServlet'>Error, try again later!<input type='submit' class='closebtn' value='X'/></form>");  
	        	out.print("</div>");
	        }  
	          
	        out.close();  
	    }  

		
	}


