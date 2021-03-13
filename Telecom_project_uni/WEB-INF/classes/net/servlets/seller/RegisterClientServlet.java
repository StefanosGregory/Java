package net.servlets.seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.classes.ClientBean;
import net.classes.Encryption;
import net.queries.database.RegisterDao;

@WebServlet({"/RegisterClientServlet"})
public class RegisterClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RegisterDao registerDao;

    public void init() {
        registerDao = new RegisterDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username1 = session.getAttribute("username"); 
        session.setAttribute("username",username1);
    	String username = request.getParameter("username");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String afm = request.getParameter("afm");
        String plan = request.getParameter("plan");
        String psw = request.getParameter("psw");
        String psw2 = request.getParameter("psw2");
        if (!psw.equals(psw2)) {
            request.getSession();
            response.sendRedirect("seller_register_client.jsp");
        }

        ClientBean registerBean = new ClientBean();
        registerBean.setUsername(username);
        registerBean.setName(name);
        registerBean.setSurname(surname);

        float afmParsed;
        try {
            afmParsed = Float.parseFloat(afm);
        } catch (NumberFormatException var23) {
            afmParsed = 0.0F;
        }

        registerBean.setAfm(afmParsed);

        int planParsed;
        try {
            planParsed = Integer.parseInt(plan);
        } catch (NumberFormatException var22) {
            planParsed = 0;
        }

        registerBean.setPlan(planParsed);
        String hashedPsw = Encryption.getHashMD5(psw, "12345678901234567890123456789012");
	    System.out.print(hashedPsw);
        registerBean.setPassword(hashedPsw);
        Random generator = new Random();
        int num1 = 69;
        int num2 = generator.nextInt(10000000) + 1000000;
        String phoneNumber = num1 + Integer.toString(num2);
        registerBean.setPhoneNumber(phoneNumber);
        List<String> areaList = new ArrayList<String>();
        areaList.add("Athens");
        areaList.add("Thessaloniki");
        areaList.add("Piraeus");
        String area = (String)areaList.get(generator.nextInt(areaList.size()));
        registerBean.setArea(area);
        int status = 0;

        try {
            status = registerDao.RegisterClient(registerBean);
        } catch (ClassNotFoundException var21) {
            var21.printStackTrace();
        }

        if (status > 0) {
            request.getSession();
            response.sendRedirect("ClientsViewServlet");
        } else {
            response.sendRedirect("seller_register_client.jsp");
        }

    }
}
