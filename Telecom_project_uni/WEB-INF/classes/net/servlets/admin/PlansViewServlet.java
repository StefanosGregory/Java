package net.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.PlanBean;
import net.queries.database.PlanEditDao;

@WebServlet("/PlansViewServlet")
public class PlansViewServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	PlanEditDao planEditDao;
    public void init() {
    	planEditDao = new PlanEditDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username"); 
        session.setAttribute("username",username);
	       response.setContentType("text/html ");  
	       response.setCharacterEncoding("UTF-8");
	        PrintWriter out=response.getWriter();  
	        out.print("<html>");
	        out.print("<head>");
	          out.print("<link rel='stylesheet' type='text/css' href='css/PlansView.css'>");

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
	        out.print("    <a href='AdminSellersViewServlet'>Seller</a>");
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
	        out.print("      <a href='PlansViewDeleteServlet'>Delete</a>");
	        out.print("    </div>");
	        out.print("  </li>");
	        out.print("<li>"); 
	        out.print("<a href='login.jsp'>Logout</a>");
	        out.print("</li>");
	        out.print("</ul>");

	          out.print("<br>");
	          out.print("<br>");
	          
	          out.print("<form class='form1'>"); 
	          out.print("<div class='container'>");
	          out.println("<h1  class='register' >Plans List</h1>");          
	          List<PlanBean> list = planEditDao.getAllPlans();  
	          out.print("<table class='tb' border='1' width='100%'");  
	          out.print("<tr><th>ID</th><th>SMS</th><th>Data</th><th>AirTime Mins</th><th>Price</th><th>Edit</th></tr>");  
	          for(PlanBean e:list) {
	          	out.print("<tr><td class='center'>"+e.getPlan()+"</td><td>"+e.getSms()+"</td><td>"+e.getData()+"</td><td class='center'>"+e.getAirTime()+"</td><td class='center'>"+e.getPrice()+" €"+"</td><td class='center'><a class='center' href='PlanEditServlet?id="+e.getPlan()+"'> <img class='image' src='icons/edit.png'></a></td></tr>");
	          }
	          out.print("</table>");
	          out.print("<br>");
	          out.print("</div>");
	          out.print("</form>");
	          out.close();  
	      }  
	}  
