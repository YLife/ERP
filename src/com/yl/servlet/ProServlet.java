package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ProBiz;
import com.yl.biz.impl.ProBizImpl;
import com.yl.entity.Pro;
import com.yl.vo.ProVo;

public class ProServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProBiz biz = new ProBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		int page = currentPage != null ? Integer.parseInt(currentPage) : 1;
		int size = pageSize != null ? Integer.parseInt(pageSize) : 5;
		String jumpPage = request.getParameter("jumpPage");
		if (jumpPage != null && !"".equals(jumpPage)) {
			page = Integer.parseInt(jumpPage);
		}
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		ProVo vo = new ProVo();
		if (begin != null && !"".equals(begin)) {
			vo.setBegin(begin);
		}
		if (end != null && !"".equals(end)) {
			vo.setEnd(end);
		}
		List<Pro> list = biz.findAll(page, size, vo);
		int totalPage = biz.getTotalPage(size, vo);
		System.out.println(begin);
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", page);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		request.setAttribute("jumpPage", jumpPage);
		request.getRequestDispatcher("pro.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
