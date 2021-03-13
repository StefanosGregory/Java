package net.servlets.seller;

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
import net.queries.database.DeleteClientDao;


@WebServlet("/ClientsViewDeleteServlet")
public class ClientsViewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username"); 
        session.setAttribute("username",username);
        out.print("<html>");
        out.print("<head>");
          out.print("<link rel='stylesheet' type='text/css' href='css/ClientsViewDelete.css'>");

        out.print("<title>Delete client</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("  <ul>");

          out.print("  <li class='dropdown'>");
          out.print("    <a  href='seller_register_client.jsp' class='dropbtn'>Register Client</a>");
          out.print("</li>");

          out.print("  <li class='dropdown'>");
          out.print("    <a href='ClientsViewServlet' class='dropbtn'>Edit Client</a>");
          out.print("</li>");

          out.print("  <li class='dropdown1'>");
          out.print("    <a class='dropbtn1' >Delete Client</a>");
          out.print("  </li>");

          out.print("  <li class='dropdown'>");
          out.print("    <a href='ClientsViewBillsServlet' class='dropbtn'>Client's Bill</a>");
          out.print("</li>");

          out.print("  <li>");
          out.print("    <a href='login.jsp'>Logout</a>");
          out.print("  </li>");

          out.print("</ul>");
          out.print("<br>");
          out.print("<br>");
        out.print("<form class='form1'>"); 
        out.print("<div class='container'>");
        out.println("<h1  class='register' >Clients List</h1>");  
        DeleteClientDao deleteClientDao = new DeleteClientDao();
        List<ClientBean> list = deleteClientDao.getAllClients();  
        out.print("<table>");  
        out.print("<tr><th>Name</th><th>Surname</th><th>Number</th><th>Delete</th></tr>");  
        for(ClientBean e:list) {
        	out.print("<tr><td>"+e.getName()+"</td><td>"+e.getSurname()+"</td><td class='center' >"+e.getPhoneNumber()+"</td><td class='center'><a class='center' href='DeleteClientServlet?username="+e.getUsername()+"&PhoneNumber="+e.getPhoneNumber()+"'> <img class='image' src='icons/trush.png'></a></td></tr>");
        }
        out.print("</table>");
        out.print("<br>");
        out.print("</div>");
        out.print("</form>");
        out.close();  
    }  


}
