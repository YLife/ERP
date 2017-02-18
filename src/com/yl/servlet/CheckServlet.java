package com.yl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yl.biz.EmpBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.entity.Emp;

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpBiz biz = new EmpBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String empId = request.getParameter("empId");
		String empPwd = request.getParameter("empPwd");
		String validate = request.getParameter("validate");
		String code = (String)session.getAttribute("code");
		Emp emp = biz.findById(Integer.parseInt(empId));
		if (emp != null) {
			if (empPwd.equals(emp.getEmpPwd())) {
				if (validate.equalsIgnoreCase(code)) {
					session.setAttribute("empId", empId);
					session.setAttribute("empName", emp.getEmpName());
					session.setAttribute("roleName", emp.getEmpRole().getRoleName());
					session.removeAttribute("validate");
					response.sendRedirect("index.jsp");					
				}else {
					out.print("<script>alert('验证码错误!');window.history.go(-1)</script>");
				}
			}else {
				out.print("<script>alert('密码错误!');window.history.go(-1)</script>");
			}
		}else{
			out.print("<script>alert('该用户不存在!');window.history.go(-1)</script>");
		}
	}

}
