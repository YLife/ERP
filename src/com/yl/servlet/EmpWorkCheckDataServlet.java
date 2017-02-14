package com.yl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpWorkCaseBiz;
import com.yl.biz.impl.EmpWorkCaseBizImpl;
import com.yl.entity.Emp;

public class EmpWorkCheckDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpWorkCaseBiz biz = new EmpWorkCaseBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String empId = request.getParameter("empId");
		Emp emp = biz.findById(Integer.parseInt(empId));
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("empWorkCheckData.jsp").forward(request, response);
	}

}
