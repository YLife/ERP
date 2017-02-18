package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpJobBiz;
import com.yl.biz.impl.EmpJobBizImpl;
import com.yl.entity.EmpJob;

public class DoEmpJobAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpJobBiz biz = new EmpJobBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String jobName = request.getParameter("jobName");
		System.out.println(jobName);
		EmpJob empJob = new EmpJob(0, jobName);
		int row = biz.save(empJob);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
