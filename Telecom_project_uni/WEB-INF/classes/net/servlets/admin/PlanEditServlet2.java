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
import net.queries.database.PlanEditDao;


@WebServlet("/PlanEditServlet2")
public class PlanEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PlanEditDao planEditDao;
    public void init() {
    	planEditDao = new PlanEditDao();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username"); 
        session.setAttribute("username",username);
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
            out.print("<link rel='stylesheet' type='text/css' href='css/admin_edit_plan.css'>");
	        int id = Integer.parseInt(request.getParameter("id"));
	        String sms=request.getParameter("sms");  
	        String data=request.getParameter("data");  
	        String airtime=request.getParameter("airtime");  
	        String price=request.getParameter("price");  
	          
	        PlanBean planBean = new PlanBean();   
	        planBean.setPlan(id);
	        planBean.setSms(sms);
	        planBean.setData(data);
	        planBean.setAirTime(airtime);
	        planBean.setPrice(price);
	        	       
	        int status=planEditDao.update(planBean);  
	        if(status>0){  
	            response.sendRedirect("PlansViewServlet");  
	        }else{  
	        	out.print("<div class='alert'>");
	  	        out.print("<form action='PlansViewServlet'>Error, try again later!<input type='submit' class='closebtn' value='X'/></form>");  
	        	out.print("</div>");
	        }  
	          
	        out.close();  
	    }  
	  
	}


