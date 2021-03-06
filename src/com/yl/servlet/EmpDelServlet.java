package com.yl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.impl.EmpBizImpl;

public class EmpDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpBiz biz = new EmpBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String mess[] = request.getParameterValues("delid");
		int row = 0;
		for (int i = 0; i < mess.length; i++) {
			row += biz.del(Integer.parseInt(mess[i]));
		}
		
		if (row == mess.length) {
			response.sendRedirect("EmpServlet");
		}
	}

}
