package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.impl.ProModBizImpl;
import com.yl.biz.ProModBiz;
import com.yl.entity.ProMod;

public class ProModDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProModBiz biz = new ProModBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String modId = request.getParameter("modId");
		ProMod proMod = biz.findById(Integer.parseInt(modId));
		request.setAttribute("proMod", proMod);
		request.getRequestDispatcher("proModData.jsp").forward(request, response);
	}

}
