package net.servlets.admin;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.ClientBean;
import net.classes.Encryption;
import net.queries.database.SellerRegisterDao;


@WebServlet("/AdminRegisterSellerServlet")
public class AdminRegisterSellerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	SellerRegisterDao sellerRegisterDao;

    public void init() {
    	sellerRegisterDao = new SellerRegisterDao();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username1 = session.getAttribute("username"); 
        session.setAttribute("username",username1);
		 String username = request.getParameter("username");
		 String name = request.getParameter("name");
		 String surname = request.getParameter("surname");
		 String psw = request.getParameter("psw");
		 String psw2 = request.getParameter("psw2");
	 		 
		if(!psw.equals(psw2)) {
		
		request.getSession();
		response.sendRedirect("seller_register_client.jsp");		 
		}
				 		 		
		 
	     ClientBean registerBean = new ClientBean();
	     registerBean.setUsername(username);
	     registerBean.setName(name);
	     registerBean.setSurname(surname);
	     String hashedPsw = Encryption.getHashMD5(psw, "12345678901234567890123456789012");
	     System.out.print(hashedPsw);
	     registerBean.setPassword(hashedPsw);
	     
		 int status= 0;
		 
		try {
			 
			 status = sellerRegisterDao.RegisterSeller(registerBean);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 if(status >0) {
			 request.getSession();
			 response.sendRedirect("admin_page.jsp");
		 }else {
			 request.getSession();
			 response.sendRedirect("admin_page.jsp");
		 }
		 
	     
	}

}
