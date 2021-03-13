package net.servlets;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.Encryption;
import net.classes.LoginBean;
import net.queries.database.LoginDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	LoginDao loginDao = new LoginDao();
        LoginBean loginBean = new LoginBean();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String property;
        loginBean.setUsername(username);
        
        System.out.println(password);       
	    String hashedPsw = Encryption.getHashMD5(password, "12345678901234567890123456789012");
	    System.out.println(hashedPsw);
	    loginBean.setPassword(hashedPsw);

        try {
            if (loginDao.validate(loginBean)) {
                HttpSession session = request.getSession();
                 session.setAttribute("username",username);
                 property = loginDao.propertyCheck(loginBean,username,hashedPsw);

                 if(property.equals("Seller")){
                	 session = request.getSession();
                     session.setAttribute("property",property);
                	 System.out.println("seller menu loading");
                	 request.setAttribute("username", username);
                	 session.setAttribute("username",username);
                	 response.sendRedirect("seller_page.jsp");}
                 
                 else if (property.equals("Client")) {
                	 session = request.getSession();
                     session.setAttribute("property",property);
                	 System.out.println("Client menu loading");
                	 request.setAttribute("username", username);
                	 session.setAttribute("username",username);
                	 response.sendRedirect("client_page.jsp");}
                 
                 else if (property.equals("Admin")) {
                	 session = request.getSession();
                     session.setAttribute("property",property);
                	 System.out.println("Admin menu loading");
                	 request.setAttribute("username", username);
                	 session.setAttribute("username",username);
                	 response.sendRedirect("admin_page.jsp");}
                 else System.out.println("Something Wrong with user property");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("login.jsp");
             
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}