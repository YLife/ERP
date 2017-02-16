package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.PriorityBiz;
import com.yl.biz.ProBiz;
import com.yl.biz.impl.PriorityBizImpl;
import com.yl.biz.impl.ProBizImpl;
import com.yl.entity.Priority;
import com.yl.entity.Pro1;
import com.yl.vo.PriorityVo;

public class ProModAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProBiz pbiz = new ProBizImpl();
	private PriorityBiz biz = new PriorityBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		List<Pro1> list1 = pbiz.findPro1s();
		PriorityVo vo = new PriorityVo();
		List<Priority> list2 = biz.findAll(0, 5, vo);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("proModAdd.jsp").forward(request, response);
	}

}
