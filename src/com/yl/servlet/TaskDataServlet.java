package com.yl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.TaskBiz;
import com.yl.biz.impl.TaskBizImpl;
import com.yl.entity.Task;

public class TaskDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskBiz biz = new TaskBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String taskId = request.getParameter("taskId");
		Task task = biz.findById(Integer.parseInt(taskId));
		request.setAttribute("task", task);
		request.getRequestDispatcher("taskData.jsp").forward(request, response);
	}

}
