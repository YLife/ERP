package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yl.biz.EmpBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.entity.Emp;

public class EmpDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpBiz biz = new EmpBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String empId = (String)session.getAttribute("empId");
		Emp emp = biz.findById(Integer.parseInt(empId));
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("empData.jsp").forward(request, response);
	}

}
