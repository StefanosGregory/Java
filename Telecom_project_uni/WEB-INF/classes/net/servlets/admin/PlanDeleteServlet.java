package net.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.PlanBean;
import net.queries.database.PlanDeleteDao;


@WebServlet("/PlanDeleteServlet")
public class PlanDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username"); 
        session.setAttribute("username",username);  
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.print("<link rel='stylesheet' type='text/css' href='css/PlansView.css'>");
	        int id = Integer.parseInt(request.getParameter("id")); 
	        PlanBean planBean = new PlanBean();  
	        planBean.setPlan(id);
	        PlanDeleteDao planDeleteDao = new PlanDeleteDao();
	        int status = planDeleteDao.delete(planBean);
	        if(status>0){  
	            response.sendRedirect("PlansViewDeleteServlet");  
	        }else{  
	        	out.print("<div class='alert'>");
	  	        out.print("<form action='PlansViewDeleteServlet'>Error, try again later!<input type='submit' class='closebtn' value='X'/></form>");  
	        	out.print("</div>");
	        }  
	          
	        out.close();  
	    }  

		
	}


