package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpSalTypeBiz;
import com.yl.biz.impl.EmpSalTypeBizImpl;
import com.yl.entity.EmpSalType;

public class DoEmpSalTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpSalTypeBiz biz = new EmpSalTypeBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String empSalTypeId = request.getParameter("empSalTypeId");
		String empSalTypeName = request.getParameter("empSalTypeName");
		String empSalTypeAmount = request.getParameter("empSalTypeAmount");
		String empSalTypeRemark = request.getParameter("empSalTypeRemark");
		EmpSalType est = biz.findById(Integer.parseInt(empSalTypeId));
		est.setSalTypeName(empSalTypeName);
		est.setSalTypeAmount(empSalTypeAmount);
		est.setSalTypeRemark(empSalTypeRemark);
		int row = biz.update(est);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
