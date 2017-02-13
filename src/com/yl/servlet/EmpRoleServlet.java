package com.yl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpRoleBiz;
import com.yl.biz.impl.EmpRoleBizImpl;
import com.yl.entity.EmpRole;
import com.yl.vo.EmpRoleVo;

public class EmpRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpRoleBiz biz = new EmpRoleBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		int page = currentPage != null ? Integer.parseInt(currentPage) : 1;
		int size = pageSize != null ? Integer.parseInt(pageSize) : 5;
		EmpRoleVo vo = new EmpRoleVo();
		List<EmpRole> list = biz.findAll(page , size, vo);
		int totalPage = biz.getTotalPage(size, vo);
		request.setAttribute("list", list);
		request.setAttribute("currentPage", page);
		request.setAttribute("pageSize", size);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("");
	}

}
