package com.digit.hibernatServlet.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.Model.HibernateManager;



@WebServlet("/Delete")
public class Delete extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int aadharId = (Integer.parseInt(req.getParameter("aadhar_id")));


        HibernateManager hbm = new HibernateManager();

        hbm.deleteData(aadharId);

        res.sendRedirect("DeleteSuccess.html");
    }
}
