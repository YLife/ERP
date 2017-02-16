package com.yl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ProFunBiz;
import com.yl.biz.impl.ProFunBizImpl;
import com.yl.entity.ProFun;

public class ProFunDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProFunBiz biz = new ProFunBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String funId = request.getParameter("proFunId");
		ProFun proFun = biz.findById(Integer.parseInt(funId));
		request.setAttribute("proFun", proFun);
		request.getRequestDispatcher("proFunData.jsp").forward(request, response);
	}

}
