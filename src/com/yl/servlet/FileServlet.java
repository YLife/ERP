package com.yl.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.FileBiz;
import com.yl.biz.impl.FileBizImpl;
import com.yl.entity.Files;
import com.yl.vo.FileVo;

public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileBiz biz = new FileBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String jumpPage = request.getParameter("jumpPage");
		int page = currentPage != null ? Integer.parseInt(currentPage) : 1;
		int size = pageSize != null ? Integer.parseInt(pageSize) : 5;
		if (jumpPage != null && !"".equals(jumpPage)) {
			page = Integer.parseInt(jumpPage);
		}
		FileVo vo = new FileVo();
		String fileName = request.getParameter("fileName");	
		if (fileName != null && !"".equals(fileName)) {
			vo.setFileName(fileName);
		}
		List<Files> list = biz.findAll(page, size, vo);
		int totalPage = biz.getTotalPage(size, vo);
		request.setAttribute("list", list);
		request.setAttribute("fileName", fileName);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", page);
		request.setAttribute("jumpPage", jumpPage);
		request.getRequestDispatcher("proUpload.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
