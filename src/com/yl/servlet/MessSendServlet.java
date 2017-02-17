package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.entity.Emp;
import com.yl.vo.EmpVo;

public class MessSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpBiz biz = new EmpBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;");
		EmpVo vo = new EmpVo();
		List<Emp> list = biz.findAll(1, Integer.MAX_VALUE, vo);
		request.setAttribute("list", list);
		request.getRequestDispatcher("messSend.jsp").forward(request, response);
	}

}
