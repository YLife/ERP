package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ClientBiz;
import com.yl.biz.impl.ClientBizImpl;
import com.yl.entity.Client;

public class ClientDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBiz biz =new ClientBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		int clientId = Integer.parseInt(request.getParameter("clientId"));
		Client client = biz.findById(clientId);
		request.setAttribute("client", client);
		request.getRequestDispatcher("clientData.jsp").forward(request, response);
	}

}
