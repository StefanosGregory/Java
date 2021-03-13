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

@WebServlet("/PlanEditServlet")
public class PlanEditServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	PlanEditDao planEditDao;
    public void init() {
    	planEditDao = new PlanEditDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username"); 
        session.setAttribute("username",username);
	       response.setContentType("text/html");  
	       response.setCharacterEncoding("UTF-8");
	        PrintWriter out=response.getWriter();  
	        out.print("<html>");
	        out.print("<head>");
	          out.print("<link rel='stylesheet' type='text/css' href='css/admin_edit_plan.css'>");

		        out.print("<title>Edit Plan</title>");
		        out.print("</head>");
		        out.print("<body>");
		        out.print("<ul>");
		        out.print("<li class='dropdown'>");
		        out.print("    <a class='dropbtn'>Register</a>");
		        out.print("  <div class='dropdown-content'>");
		        out.print("    <a href='admin_register_client.jsp' >Client</a>");
		        out.print("    <a href='admin_register_seller.jsp'>Seller</a>");
		        out.print("    <a href='admin_register_admin.jsp'>Admin</a>");
		        out.print("  </div>");
		        out.print("</li>");

		        out.print("  <li class='dropdown'>");
		        out.print("    <a class='dropbtn'>Edit Profile</a>");
		        out.print("  <div class='dropdown-content'>");
		        out.print("    <a href='AdminClientsViewServlet'>Client</a>");
		        out.print("    <a href='AdminSellersViewServlet.jsp'>Seller</a>");
		        out.print("  </div>");
		        out.print("</li>");

		        out.print("  <li class='dropdown'>");
		        out.print("    <a  class='dropbtn'>Delete Profile</a>");
		        out.print("    <div class='dropdown-content'>");
		        out.print("      <a href='AdminClientsViewDeleteServlet'>Client</a>");
		        out.print("      <a href='AdminSellerViewDeleteServlet'>Seller</a>");
		        out.print("    </div>");
		        out.print("  </li>");

		        out.print("  <li class='dropdown'>");
		        out.print("    <a  class='dropbtn1'>Plan</a>");
		        out.print("    <div class='dropdown-content'>");
		        out.print("      <a href='admin_create_plan.jsp'>Create</a>");
		        out.print("      <a class='edit'>Edit</a>");
		        out.print("      <a href='admin_delete_plan.jsp'>Delete</a>");
		        out.print("    </div>");
		        out.print("  </li>");


	        out.print("</ul>");

	          out.print("<br>");
	          out.print("<br>");
	          
	        out.print("<form class='form1' action='PlanEditServlet2' method='post'>"); 
	        out.print("<div class='container'> ");   
	        int id = Integer.parseInt(request.getParameter("id")); 
	        out.println("<h1 class='register' >Update plan "+id+"</h1>");
	        PlanBean e = planEditDao.getPlanById(id);    
	        out.print("<table>");  
	        out.print("<tr><td><input type='hidden' name='id' value='"+id+"'/></td></tr>");  
	        out.print("<label for='sms'><b>SMS:</b></label><br><input type='text' name='sms' value='"+e.getSms()+"' required/>");
	        out.print("<label for='data'><b>Data:</b></label><br><input type='text' name='data' value='"+e.getData()+"'  required/>");
	        out.print("<label for='airTime'><b>AirTime Mins:</b></label><br><input type='text' name='airtime' value='"+e.getAirTime()+"' required/><br>");
	        out.print("<label for='price'><b>Price:</b></label><br><input type='text' name='price' value='"+e.getPrice()+"' required/>");
	        out.print("</td></tr><br>"); 
	        out.print("<hr>");
	        out.print("<form action='PlanEditServlet2' method='post' >"); 
	        out.print("<input type='submit' class='registerbtn' value='Edit & Save '/>");
	        out.print("</form>"); 
	        out.print("<form action='PlansViewServlet'><input type='submit' class='cancelbtn' value='Cancel'/></form>"); 
	        out.print("</table>");  
	        out.print("</div>");  
	        out.print("</form>"); 
	        
	        out.close();  
	    }  
	}  
