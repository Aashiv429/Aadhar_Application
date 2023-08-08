package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;

@WebServlet("/Update")
public class UpdateDetails extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	int aadharId = (Integer.parseInt(req.getParameter("aadhar_id")));
    int choice =  (Integer.parseInt(req.getParameter("choice")));
    String newValue = req.getParameter("newVal");

    HibernateManager hbm = new HibernateManager();

    hbm.updateData(aadharId,choice,newValue);

    resp.sendRedirect("updateSuccess.html");
}
}