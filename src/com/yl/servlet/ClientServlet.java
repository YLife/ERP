package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ClientBiz;
import com.yl.biz.impl.ClientBizImpl;
import com.yl.entity.Client;
import com.yl.vo.ClientVo;

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBiz biz = new ClientBizImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		int page = currentPage != null ? Integer.parseInt(currentPage) : 1;
		int size = pageSize != null ? Integer.parseInt(pageSize) : 5;
		String jumpPage = request.getParameter("jumpPage");
		if (jumpPage != null && !"".equals(jumpPage)) {
			page = Integer.parseInt(jumpPage);
		}
		String clientcomp = request.getParameter("clientcomp");
		ClientVo vo = new ClientVo();
		if (clientcomp != null && !"".equals(clientcomp)) {
			vo.setClientcomp(clientcomp);
		}
		List<Client> list = biz.findAll(page, size, vo);
		int totalPage = biz.getTotalPage(size, vo);
		request.setAttribute("list", list);
		request.setAttribute("pageSize", size);
		request.setAttribute("currentPage", page);
		request.setAttribute("clientcomp", clientcomp);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("jumpPage", jumpPage);
		request.getRequestDispatcher("client.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
