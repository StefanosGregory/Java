package net.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.PlanBean;
import net.queries.database.PlanCreateDao;



@WebServlet("/PlanCreateServlet")
public class PlanCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PlanCreateDao planCreateDao;

    public void init() {
    	planCreateDao = new PlanCreateDao();
    }
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username"); 
        session.setAttribute("username",username);
		 String sms = request.getParameter("sms");
		 String data = request.getParameter("data");
		 String price = request.getParameter("price");
		 String airTime = request.getParameter("airtime"); 
		 
		 PlanBean planBean = new PlanBean();
		 
		 planBean.setSms(sms);
		 planBean.setData(data);
		 planBean.setPrice(price);
		 planBean.setAirTime(airTime);
		 
		 int status=0;
		 
		 try {
	            status = planCreateDao.PlanCreate(planBean);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		 
		 if (status > 0) {
	            request.getSession();
	            response.sendRedirect("admin_page.jsp");
	        } else {
	            response.sendRedirect("admin_create_plan.jsp");
	        }
	}

}
