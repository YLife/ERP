package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.PriorityBiz;
import com.yl.biz.ProBiz;
import com.yl.biz.ProModBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.biz.impl.PriorityBizImpl;
import com.yl.biz.impl.ProBizImpl;
import com.yl.biz.impl.ProModBizImpl;
import com.yl.entity.Emp;
import com.yl.entity.Emp1;
import com.yl.entity.ModPriority;
import com.yl.entity.Priority;
import com.yl.entity.Pro;
import com.yl.entity.Pro1;
import com.yl.entity.ProMod;

public class DoProModEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProModBiz biz = new ProModBizImpl();
	private PriorityBiz pbiz = new PriorityBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	private ProBiz pbiz2 = new ProBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String modId = request.getParameter("modId");
		String modName = request.getParameter("modName");
		String proId = request.getParameter("proId");
		String empName= request.getParameter("empName");
		String modPriorityId = request.getParameter("modPriorityId");
		String modRemark = request.getParameter("modRemark");
		Pro pro = pbiz2.findById(proId);
		Emp emp = ebiz.findByEmpName(empName);
		Priority priority = pbiz.findById(modPriorityId);
		ProMod proMod = biz.findById(Integer.parseInt(modId));
		proMod.setModName(modName);
		proMod.setPro1(new Pro1(pro.getProId(), pro.getProName()));
		proMod.setEmp1(new Emp1(emp.getEmpId(), emp.getEmpName()));
		proMod.setModPriority(new ModPriority(priority.getPriorityId(), priority.getPriorityName()));
		proMod.setRemark(modRemark);
		int row = biz.update(proMod);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
