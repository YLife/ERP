package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.entity.Emp;

public class DoEmpRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpBiz biz = new EmpBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String empName = request.getParameter("empName");
		String empPwd = request.getParameter("empPwd");
		Emp emp = new Emp();
		emp.setEmpId(0);
		emp.setEmpName(empName);
		emp.setEmpPwd(empPwd);
		int row = biz.register(emp);
		if (row == 1) {
			response.getWriter().print("<script>alert('×¢²á³É¹¦');window.history.go(-2);</script>");
		}
	}

}
