package com.yl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.entity.Emp;
import com.yl.vo.EmpVo;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpBiz biz = new EmpBizImpl();
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
			System.out.println(page);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		EmpVo vo = new EmpVo();
		if (begin != null && !"".equals(begin)) {
			try {
				vo.setBegin(sdf.parse(begin));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (end != null && !"".equals(end)) {
			try {
				vo.setEnd(sdf.parse(end));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		List<Emp> list = biz.findAll(page, size, vo);
		int totalPage = biz.getTotalPage(size, vo);
		Date date = new Date();
		request.setAttribute("list", list);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", page);
		request.setAttribute("date", date);
		request.setAttribute("jumpPage", jumpPage);
		request.getRequestDispatcher("emp.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
