package com.yl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.FileBiz;
import com.yl.biz.impl.FileBizImpl;

public class FileDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileBiz biz = new FileBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String files[] = request.getParameterValues("delid");
		int row = 0;
		for (int i = 0; i < files.length; i++) {
			row += biz.del(Integer.parseInt(files[i]));
		}
		if (row == files.length) {
			response.sendRedirect("FileServlet");
		}
	}

}
