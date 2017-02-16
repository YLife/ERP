package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yl.biz.PriorityBiz;
import com.yl.biz.ProModBiz;
import com.yl.biz.impl.PriorityBizImpl;
import com.yl.biz.impl.ProModBizImpl;
import com.yl.entity.Priority;
import com.yl.entity.ProMod1;
import com.yl.vo.PriorityVo;

public class ProFunAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PriorityBiz pbiz =new PriorityBizImpl();
	private ProModBiz biz = new ProModBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PriorityVo vo = new PriorityVo();
		List<ProMod1> list = biz.findAlls();
		List<Priority> list1 = pbiz.findAll(0 , 5, vo); 
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("proFunAdd.jsp").forward(request, response);
	}

}
