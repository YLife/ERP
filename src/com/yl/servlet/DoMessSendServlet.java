package com.yl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.MessBiz;
import com.yl.biz.impl.MessBizImpl;
import com.yl.entity.Mess;

public class DoMessSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessBiz biz = new MessBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String getName = request.getParameter("getName");
		String sendName = (String)request.getSession().getAttribute("empName");
		String messTitle = request.getParameter("messTitle");
		String messContent = request.getParameter("messContent");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(getName);
		Mess mess = null;
		try {
			mess = new Mess(0, messTitle, messContent, sendName, getName, sdf.parse("2007-01-01"), sdf.parse("2007-01-01"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int row = biz.save(mess);
		if (row > 0) {
			response.sendRedirect("index.jsp");
		}
	}
}
