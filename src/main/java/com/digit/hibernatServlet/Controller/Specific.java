package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.hibernateServlet.bean.AadharDetails;
@WebServlet("/Specific")
public class Specific extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int aadharId = (Integer.parseInt(req.getParameter("aadhar_id")));
        System.out.println(aadharId);
        HibernateManager hbm = new HibernateManager();
        AadharDetails user = hbm.getSpecificUser(aadharId);
        HttpSession session = req.getSession();
        if(user!=null) {
            session.setAttribute("userDetail", user);
            res.sendRedirect("showUser.jsp");
        }else {
            res.sendRedirect("fail.html");
        }
	}
}
