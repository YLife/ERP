package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.MessBiz;
import com.yl.biz.impl.MessBizImpl;
import com.yl.entity.Mess;
import com.yl.vo.MessVo;

public class MessGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessBiz biz = new MessBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String jumpPage = request.getParameter("jumpPage");
		int page = currentPage != null ? Integer.parseInt(currentPage) : 1;
		int size = pageSize != null ? Integer.parseInt(pageSize) : 5;
		String empName = (String)request.getSession().getAttribute("empName");
		if (jumpPage != null && !"".equals(jumpPage)) {
			page = Integer.parseInt(jumpPage);
		}
		MessVo vo = new MessVo();
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		if (begin != null && !"".equals(begin)) {
			vo.setBegin(begin);
		}
		if (end != null && !"".equals(end)) {
			vo.setEnd(end);
		}
		List<Mess> list = biz.findByEmpName(page, size, vo, empName);
		int totalPage = biz.getTotalPage(size, vo);
		request.setAttribute("list", list);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("jumpPage", jumpPage);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		request.getRequestDispatcher("messGet.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
