package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ProBiz;
import com.yl.biz.impl.ProBizImpl;
import com.yl.entity.Pro;

public class ProDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProBiz biz = new ProBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String proId = request.getParameter("proId");
		Pro pro = biz.findById(Integer.parseInt(proId));
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("proData.jsp").forward(request, response);
	}

}
