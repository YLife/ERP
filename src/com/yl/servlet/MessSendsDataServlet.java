package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.MessBiz;
import com.yl.biz.impl.MessBizImpl;
import com.yl.entity.Mess;

public class MessSendsDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessBiz biz = new MessBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String messId = request.getParameter("messId");
		Mess mess = biz.findById(Integer.parseInt(messId));
		request.setAttribute("mess", mess);
		request.getRequestDispatcher("messSendsData.jsp").forward(request, response);
	}

}
