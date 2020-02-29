package com.bjwl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjwl.dao.StuDao;
import com.bjwl.entity.Stu;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String sname = request.getParameter("sname");

		Stu stu = new Stu();
		stu.setSname(sname);

		StuDao dao = new StuDao();
		 List<Stu> list = dao.query(stu);
		 
		 request.setAttribute("list", list);
		 request.getRequestDispatcher("list.jsp").forward(request, response);

	}

}
