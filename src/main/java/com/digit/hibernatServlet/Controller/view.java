package com.digit.hibernatServlet.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.hibernateServlet.bean.AadharDetails;
@WebServlet("/View")
public class view extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		AadharDetails aadhar =new AadharDetails();
		HibernateManager hbm = new HibernateManager();
		HttpSession session = req.getSession();
		List showAll = hbm.showAll();
		session.setAttribute("allUser", showAll);
		if(showAll== null)
		{
			resp.sendRedirect("/ServletHibernate/viewFail.html");
		}
		else {
			resp.sendRedirect("/ServletHibernate/view.jsp");
		}
	}
}
