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

public class DoProModAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProModBiz biz = new ProModBizImpl();
	private PriorityBiz pbiz = new PriorityBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	private ProBiz pbiz2 = new ProBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		String modName = request.getParameter("modName");
		String proId = request.getParameter("proId");
		String empName= request.getParameter("empName");
		String modPriorityId = request.getParameter("modPriorityId");
		String modRemark = request.getParameter("modRemark");
		Pro pro = pbiz2.findById(proId);
		Emp emp = ebiz.findByEmpName(empName);
		Priority priority = pbiz.findById(modPriorityId);
		System.out.println(proId);
		System.out.println(emp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		ProMod proMod = null;
		try {
			proMod = new ProMod(0, modName,new Pro1(pro.getProId(), pro.getProName()), new Emp1(emp.getEmpId(), emp.getEmpName()), new ModPriority(priority.getPriorityId(), priority.getPriorityName()), sdf.parse("2006-03-05"), sdf.parse("2007-04-02"), modRemark);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int row = biz.save(proMod);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
