package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;
import com.digit.hibernateServlet.bean.AadharDetails;
@WebServlet("/Register")
public class Register extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		AadharDetails aadhar =new AadharDetails();
		aadhar.setAadharId(Integer.parseInt(req.getParameter("aadhar_id")));
		aadhar.setName(req.getParameter("name"));
		aadhar.setPhone(req.getParameter("phone"));
		aadhar.setEmail(req.getParameter("email"));
		aadhar.setAddress(req.getParameter("address"));
		aadhar.setCity(req.getParameter("city"));
		aadhar.setState(req.getParameter("state"));
		
		HibernateManager hbm = new HibernateManager();
		//session = HibernateManager.session;
		boolean b = hbm.register(aadhar);
		if(b==true)
		{
			resp.sendRedirect("/ServletHibernate/registerSuccess.html");
		}
		else {
			resp.sendRedirect("/ServletHibernate/registerFail.html");
		}
	}
}
