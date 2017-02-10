package com.yl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ClientBiz;
import com.yl.biz.impl.ClientBizImpl;
import com.yl.entity.Client;

public class DoClientEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBiz biz = new ClientBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int clientId = Integer.parseInt(request.getParameter("clientId"));
		String clientName = request.getParameter("clientName");
		String clientComp = request.getParameter("clientComp");
		String clientPhone = request.getParameter("clientPhone");
		String clientAdd= request.getParameter("clientAdd");
		String clientBack = request.getParameter("clientBack");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date clientDate = null;
		try {
			clientDate = sdf.parse(request.getParameter("clientDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Client client = new Client(clientId, clientName, clientComp, clientPhone, clientAdd, clientBack, clientDate);
		int row = biz.update(client);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
