package com.yl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpSalTypeBiz;
import com.yl.biz.impl.EmpSalTypeBizImpl;
import com.yl.entity.EmpSalType;

public class EmpSalTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpSalTypeBiz biz = new EmpSalTypeBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String empSalTypeId = request.getParameter("empSalTypeId");
		EmpSalType entity = biz.findById(Integer.parseInt(empSalTypeId));
		request.setAttribute("entity", entity);
		request.getRequestDispatcher("empSalTypeEdit.jsp").forward(request, response);
	}

}
