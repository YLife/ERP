package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ProBiz;
import com.yl.biz.ProModBiz;
import com.yl.biz.impl.ProBizImpl;
import com.yl.biz.impl.ProModBizImpl;
import com.yl.entity.Pro1;
import com.yl.entity.ProMod;
import com.yl.vo.ProModVo;

public class ProModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProModBiz biz = new ProModBizImpl();
	private ProBiz pbiz = new ProBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
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
		ProModVo vo = new ProModVo();
		if (begin != null && !"".equals(begin)) {
			vo.setBegin(begin);
		}
		if (end != null && !"".equals(end)) {
			vo.setEnd(end);
		}
		List<ProMod> list = biz.findAll(page, size, vo);
		List<Pro1> list1 = pbiz.findPro1s();
		int totalPage = biz.getTotalPage(size, vo);
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", page);
		request.setAttribute("jumpPage", jumpPage);
		request.getRequestDispatcher("proMod.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
