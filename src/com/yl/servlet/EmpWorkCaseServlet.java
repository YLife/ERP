package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpWorkCaseBiz;
import com.yl.biz.impl.EmpWorkCaseBizImpl;
import com.yl.entity.Emp;
import com.yl.vo.EmpWorkCaseVo;

public class EmpWorkCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpWorkCaseBiz biz = new EmpWorkCaseBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		int page = currentPage != null ? Integer.parseInt(currentPage) : 1;
		int size = pageSize != null ? Integer.parseInt(pageSize) : 5;
		String first = request.getParameter("first");
		String second = request.getParameter("second");
		String jumpPage = request.getParameter("jumpPage");
		if (jumpPage != null && !"".equals(jumpPage)) {
			page = Integer.parseInt(jumpPage);
		}
		EmpWorkCaseVo vo = new EmpWorkCaseVo();
		if (first != null && !"".equals(first)) {
			vo.setFirst(first);
		}
		if (second != null && !"".equals(second)) {
			vo.setSecond(second);
		}
		List<Emp> list = biz.findAll(page, size, vo);
		int totalPage = biz.getTotalPage(size, vo);
		request.setAttribute("list", list);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("first", first);
		request.setAttribute("second", second);
		request.setAttribute("jumpPage", jumpPage);
		request.getRequestDispatcher("empWorkCase.jsp").forward(request, response);;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
