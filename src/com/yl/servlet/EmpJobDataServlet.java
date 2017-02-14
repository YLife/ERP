package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpJobBiz;
import com.yl.biz.impl.EmpJobBizImpl;
import com.yl.entity.EmpJob;

public class EmpJobDataServlet extends HttpServlet {
	private EmpJobBiz biz = new EmpJobBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String jobId = request.getParameter("jobId");
		EmpJob empJob = biz.findById(Integer.parseInt(jobId));
		request.setAttribute("empJob", empJob);
		request.getRequestDispatcher("empJobData.jsp").forward(request, response);
	}

}
