package com.yl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import com.yl.entity.Emp1;
import com.yl.entity.Priority;
import com.yl.entity.Pro;
import com.yl.entity.Pro1;
import com.yl.entity.ProFun;
import com.yl.entity.ProFun1;
import com.yl.entity.ProMod;
import com.yl.entity.ProMod1;
import com.yl.entity.Task;

public class DoTaskAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskBiz biz = new TaskBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	private PriorityBiz pbiz = new PriorityBizImpl();
	private ProBiz pbiz1 = new ProBizImpl();
	private ProModBiz mbiz = new ProModBizImpl();
	private ProFunBiz fbiz = new ProFunBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String taskName = request.getParameter("taskName");
		String proId = request.getParameter("proId");
		String modId = request.getParameter("modId");
		String funId = request.getParameter("funId");
		String empId = request.getParameter("empId");
		String priorityId = request.getParameter("priorityId");
		String createDate = request.getParameter("createDate");
		String endDate = request.getParameter("endDate");
		String taskNote = request.getParameter("taskNote");
		Pro pro = pbiz1.findById(Integer.parseInt(proId));
		ProMod proMod = mbiz.findById(Integer.parseInt(modId));
		ProFun proFun = fbiz.findById(Integer.parseInt(funId));
		Priority priority = pbiz.findById(Integer.parseInt(priorityId));
		Emp emp = ebiz.findById(Integer.parseInt(empId));
		Task task = new Task();
		task.setTaskId(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		task.setTaskName(taskName);
		task.setPro1(new Pro1(pro.getProId(), pro.getProName()));
		task.setMod1(new ProMod1(proMod.getModId(), proMod.getModName(), new Pro1(pro.getProId(), pro.getProName())));
		task.setFun1(new ProFun1(proFun.getFunId(), proFun.getFunName()));
		task.setEmp1(new Emp1(emp.getEmpId(), emp.getEmpName()));
		task.setPriority(priority);
		try {
			task.setCreateDate(sdf.parse(createDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			task.setEndDate(sdf.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		task.setTaskNote(taskNote);
		int row = biz.save(task);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
