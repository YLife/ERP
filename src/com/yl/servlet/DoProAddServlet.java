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

public class DoProAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProBiz biz = new ProBizImpl();
	private PriorityBiz pbiz = new PriorityBizImpl();
	private ProStateBiz sbiz = new ProStateBizImpl();
	private ClientBiz cbiz = new ClientBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
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
		Client client = cbiz.findByClientComp(clientComp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Pro pro = null;
		try {
			pro = new Pro(0, proName, Double.parseDouble(proAmount), client, emp, Integer.parseInt(devNum), sdf.parse("2003-01-01"), sdf.parse(startDate), sdf.parse(endDate), Double.parseDouble(proCost), remark, priority, proState);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int row = biz.save(pro);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
		
	}

}
