package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.PriorityBiz;
import com.yl.biz.ProBiz;
import com.yl.biz.ProFunBiz;
import com.yl.biz.ProModBiz;
import com.yl.biz.TaskBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.biz.impl.PriorityBizImpl;
import com.yl.biz.impl.ProBizImpl;
import com.yl.biz.impl.ProFunBizImpl;
import com.yl.biz.impl.ProModBizImpl;
import com.yl.biz.impl.TaskBizImpl;
import com.yl.entity.Emp;
import com.yl.entity.Priority;
import com.yl.entity.Pro1;
import com.yl.entity.ProFun;
import com.yl.entity.ProMod1;
import com.yl.entity.Task;
import com.yl.vo.EmpVo;
import com.yl.vo.PriorityVo;
import com.yl.vo.ProFunVo;

public class TaskEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskBiz biz = new TaskBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	private PriorityBiz pbiz = new PriorityBizImpl();
	private ProBiz pbiz1 = new ProBizImpl();
	private ProModBiz mbiz = new ProModBizImpl();
	private ProFunBiz fbiz = new ProFunBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String taskId = request.getParameter("taskId");
		Task task = biz.findById(Integer.parseInt(taskId));
		EmpVo vo1 = new EmpVo();
		List<Emp> list1 = ebiz.findAll(1 , Integer.MAX_VALUE, vo1);
		PriorityVo vo2 = new PriorityVo();
		List<Priority> list2 = pbiz.findAll(1,Integer.MAX_VALUE , vo2);
		List<Pro1> list3 = pbiz1.findPro1s();
		List<ProMod1> list4 = mbiz.findAlls();
		ProFunVo vo3 = new ProFunVo();
		List<ProFun> list5 = fbiz.findAll(1, Integer.MAX_VALUE, vo3);
		request.setAttribute("task", task);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		request.setAttribute("list5", list5);
		request.getRequestDispatcher("taskEdit.jsp").forward(request, response);
	}

}
