package com.yl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yl.biz.EmpSalBiz;
import com.yl.biz.impl.EmpSalBizImpl;
import com.yl.entity.EmpSal;
import com.yl.entity.EmpSalState;

public class DoEmpSalSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpSalBiz sbiz = new EmpSalBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String empId = request.getParameter("empId");
		String salType = request.getParameter("salType");
		String salRemark = request.getParameter("salRemark");
		System.out.println(salType);
		EmpSal es = sbiz.findById(Integer.parseInt(empId));
		es.setSalType(salType);
		es.setRemark(salRemark);
		es.setSalState(new EmpSalState(1, "ÒÑ·¢·Å"));
		int row = sbiz.update(es);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
