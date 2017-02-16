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

public class DoProFunAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProFunBiz biz = new ProFunBizImpl();
	private ProModBiz pbiz = new ProModBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	private PriorityBiz pbiz1 = new PriorityBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String funName = request.getParameter("funName");
		String empName = request.getParameter("empName");
		String funPriorityId = request.getParameter("funPriorityId");
		String modId = request.getParameter("modId");
		String remark = request.getParameter("funRemark");
		ProMod proMod = pbiz.findById(Integer.parseInt(modId));
		Emp emp = ebiz.findByEmpName(empName);
		Priority priority = pbiz1.findById(Integer.parseInt(funPriorityId));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		ProFun proFun = null;
		try {
			proFun = new ProFun(0, funName, new ProMod1(proMod.getModId(), proMod.getModName(), new Pro1(proMod.getPro1().getProId(), proMod.getPro1().getProName())), new Emp1(emp.getEmpId(), emp.getEmpName()), new FunPriority(priority.getPriorityId(), priority.getPriorityName()), sdf.parse("2005-01-01"), remark);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int row = biz.save(proFun);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
