package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.TaskBiz;
import com.yl.biz.impl.TaskBizImpl;
import com.yl.entity.Task;
import com.yl.vo.TaskVo;

public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskBiz biz = new TaskBizImpl();
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
		TaskVo vo = new TaskVo();
		if (begin != null && !"".equals(begin)) {
			vo.setBegin(begin);
		}
		if (end != null && !"".equals(end)) {
			vo.setEnd(end);
		}
		List<Task> list = biz.findAll(page, size, vo);
		int totalPage = biz.getTotalPage(size, vo);
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", page);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		request.setAttribute("jumpPage", jumpPage);
		request.getRequestDispatcher("task.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
