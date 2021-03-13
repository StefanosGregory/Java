package net.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.ClientBean;
import net.queries.database.EditSellerDao;

@WebServlet("/AdminEditSellerServlet")
public class AdminEditSellerServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	EditSellerDao editSellerDao;
    public void init() {
        editSellerDao = new EditSellerDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username"); 
        session.setAttribute("username",username);
	       response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.print("<html>");
	        out.print("<head>");
	          out.print("<link rel='stylesheet' type='text/css' href='css/seller_edit_client.css'>");

	        out.print("<title>Edit client</title>");
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
	        out.print("    <a class='dropbtn1'>Edit Profile</a>");
	        out.print("  <div class='dropdown-content'>");
	        out.print("    <a class='client'>Client</a>");
	        out.print("    <a href='admin_edit_profile_seller.jsp'>Seller</a>");
	        out.print("  </div>");
	        out.print("</li>");

	        out.print("  <li class='dropdown'>");
	        out.print("    <a  class='dropbtn'>Delete Profile</a>");
	        out.print("    <div class='dropdown-content'>");
	        out.print("      <a href='admin_delete_profile_client.jsp'>Client</a>");
	        out.print("      <a href='admin_delete_profile_seller.jsp'>Seller</a>");
	        out.print("    </div>");
	        out.print("  </li>");

	        out.print("  <li class='dropdown'>");
	        out.print("    <a  class='dropbtn'>Plan</a>");
	        out.print("    <div class='dropdown-content'>");
	        out.print("      <a href='admin_create_plan.jsp'>Create</a>");
	        out.print("      <a href='admin_edit_plan.jsp'>Edit</a>");
	        out.print("      <a href='admin_delete_plan.jsp'>Delete</a>");
	        out.print("    </div>");
	        out.print("  </li>");

	        out.print("</ul>");

	          out.print("<br>");
	          out.print("<br>");
	          
	        out.print("<form class='form1' action='AdminEditSellerServlet2' method='post'>"); 
	        out.print("<div class='container'> ");   
	        String Username = request.getParameter("username"); 
	        out.println("<h1 class='register' >Update "+Username+"</h1>");
	        ClientBean e = editSellerDao.getSellerByUsername(Username);    
	        out.print("<table>");  
	        out.print("<tr><td><input type='hidden' name='username' value='"+Username+"'/></td></tr>");  
	        out.print("<label for='name'><b>Name:</b></label><br><input type='text' name='name' value='"+e.getName()+"' pattern='[A-Za-z]{1,20}' required/>");
	        out.print("<label for='surnname'><b>Surname:</b></label><br><input type='text' name='surname' value='"+e.getSurname()+"' pattern='[A-Za-z]{1,20}' required/>");
	        out.print("<label for='password'><b>Password:</b></label><br><input type='text' name='password' value='"+e.getPassword()+"' required/><br>"); 
	        out.print("<label for='property'><b>Property: Seller</b></label><br><br>");    
	        out.print("</td></tr><br>"); 
	        out.print("<hr>");
	        out.print("<input type='submit' class='registerbtn' value='Edit & Save '/>");
	        out.print("<form action='AdminSellerViewServlet'><input type='submit' class='cancelbtn' value='Cancel'/></form>"); 
	        out.print("</table>");  
	        out.print("</div>");  
	        out.print("</form>");  
	          
	        out.close();  
	    }  
	}  
