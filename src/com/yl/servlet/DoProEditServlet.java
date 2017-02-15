package com.yl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.ClientBiz;
import com.yl.biz.EmpBiz;
import com.yl.biz.PriorityBiz;
import com.yl.biz.ProBiz;
import com.yl.biz.ProStateBiz;
import com.yl.biz.impl.ClientBizImpl;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.biz.impl.PriorityBizImpl;
import com.yl.biz.impl.ProBizImpl;
import com.yl.biz.impl.ProStateBizImpl;
import com.yl.entity.Client;
import com.yl.entity.Emp;
import com.yl.entity.Priority;
import com.yl.entity.Pro;
import com.yl.entity.ProState;

public class DoProEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProBiz biz = new ProBizImpl();
	private PriorityBiz pbiz = new PriorityBizImpl();
	private ProStateBiz sbiz = new ProStateBizImpl();
	private ClientBiz cbiz = new ClientBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String proId = request.getParameter("proId");
		String proName = request.getParameter("proName");
		String clientComp = request.getParameter("clientComp");
		String proAmount = request.getParameter("proAmount");
		String devNum = request.getParameter("devNum");
		String managerName = request.getParameter("managerName");
		String proStateId = request.getParameter("proStateId");
		String proCost = request.getParameter("proCost");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String priorityId = request.getParameter("priorityId");
		String remark = request.getParameter("remark");
		Priority priority = pbiz.findById(Integer.parseInt(priorityId));
		ProState proState = sbiz.findById(Integer.parseInt(proStateId));
		Emp emp = ebiz.findByEmpName(managerName);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Client client = cbiz.findByClientComp(clientComp);
		Pro pro = biz.findById(Integer.parseInt(proId));
		pro.setProName(proName);
		pro.setClient(client);
		pro.setProAmount(Double.parseDouble(proAmount));
		pro.setDevNum(Integer.parseInt(devNum));
		pro.setEmp(emp);
		pro.setProState(proState);
		pro.setProCost(Double.parseDouble(proCost));
		try {
			pro.setStartDate(sdf.parse(startDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			pro.setEndDate(sdf.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pro.setPriority(priority);
		pro.setRemark(remark);
		int row = biz.update(pro);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}

}
