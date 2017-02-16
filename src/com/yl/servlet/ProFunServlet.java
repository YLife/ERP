package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ProFunBiz;
import com.yl.biz.impl.ProFunBizImpl;
import com.yl.entity.ProFun;
import com.yl.vo.ProFunVo;

public class ProFunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProFunBiz biz = new ProFunBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String jumpPage = request.getParameter("jumpPage");
		String funName = request.getParameter("funName");
		int page = currentPage != null ? Integer.parseInt(currentPage) : 1;
		int size = pageSize != null ? Integer.parseInt(pageSize) : 5;
		if (jumpPage != null && !"".equals(jumpPage)) {
			page = Integer.parseInt(jumpPage);
		}
		ProFunVo vo = new ProFunVo();
		if (funName != null && !"".equals(funName)) {
			vo.setFunName(funName);
		}
		List<ProFun> list = biz.findAll(page, size, vo);
		int totalPage = biz.getTotalPage(size, vo);
		request.setAttribute("currentPage", page);
		request.setAttribute("list", list);
		request.setAttribute("funName", funName);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("jumpPage", jumpPage);
		request.getRequestDispatcher("proFun.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
