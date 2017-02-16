package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.PriorityBiz;
import com.yl.biz.ProFunBiz;
import com.yl.biz.ProModBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.biz.impl.PriorityBizImpl;
import com.yl.biz.impl.ProFunBizImpl;
import com.yl.biz.impl.ProModBizImpl;
import com.yl.entity.Emp;
import com.yl.entity.Emp1;
import com.yl.entity.FunPriority;
import com.yl.entity.Priority;
import com.yl.entity.Pro1;
import com.yl.entity.ProFun;
import com.yl.entity.ProMod;
import com.yl.entity.ProMod1;

public class DoProFunEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProFunBiz biz = new ProFunBizImpl(); 
	private ProModBiz pbiz = new ProModBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	private PriorityBiz pbiz1 = new PriorityBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String funId = request.getParameter("funId");
		String empName = request.getParameter("empName");
		String funName = request.getParameter("funName");
		String funPriorityId = request.getParameter("funPriorityId");
		String modId = request.getParameter("modId");
		String remark = request.getParameter("funRemark");
		Emp emp = ebiz.findByEmpName(empName);
		Priority priority = pbiz1.findById(Integer.parseInt(funPriorityId));
		ProMod mod = pbiz.findById(Integer.parseInt(modId));
		ProFun proFun = biz.findById(Integer.parseInt(funId));
		proFun.setEmp1(new Emp1(emp.getEmpId(), empName));
		proFun.setFunName(funName);
		proFun.setFunPriority(new FunPriority(priority.getPriorityId(), priority.getPriorityName()));
		proFun.setMod1(new ProMod1(mod.getModId(), mod.getModName(), new Pro1(mod.getPro1().getProId(), mod.getPro1().getProName())));
		proFun.setRemark(remark);
		int row = biz.update(proFun);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
