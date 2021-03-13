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
import net.classes.Encryption;
import net.queries.database.EditClientDao;

/**
 * Servlet implementation class EditClientServlet2
 */
@WebServlet("/EditClientServlet2")
public class EditClientServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	EditClientDao editClientDao;
    public void init() {
        editClientDao = new EditClientDao();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession();
        Object username1 = session.getAttribute("username"); 
        session.setAttribute("username",username1);  
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
            out.print("<link rel='stylesheet' type='text/css' href='css/seller_edit_client.css'>");
	        String username = request.getParameter("username");
	        String name=request.getParameter("name");  
	        String surname=request.getParameter("surname");  
	        String password=request.getParameter("password");  
	        int plan= Integer.parseInt(request.getParameter("plan")); 
	          
	        ClientBean e=new ClientBean();  
	        e.setUsername(username);
	        e.setName(name);  
            e.setSurname(surname); 
            String hashedPsw = Encryption.getHashMD5(password, "12345678901234567890123456789012");
    	    System.out.println(hashedPsw);
            e.setPassword(hashedPsw);     
            e.setPlan(plan);
	       
	        int status=editClientDao.update(e);  
	        if(status>0){  
	            response.sendRedirect("ClientsViewServlet");  
	        }else{  
	        	out.print("<div class='alert'>");
	  	        out.print("<form action='ClientsViewServlet'>Error, try again later!<input type='submit' class='closebtn' value='X'/></form>");  
	        	out.print("</div>");
	        }  
	          
	        out.close();  
	    }  
	  
	}


