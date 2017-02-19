package com.yl.servlet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String file = request.getParameter("file");
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/files/"+file);
		InputStream in = new FileInputStream(realPath);
		OutputStream out = response.getOutputStream();
		// ��֪����������Ǹ�����ʽ������ֱ�Ӵ򿪡�
		response.setHeader("Content-Disposition", "attachment;filename=" + file);
		// ��֪��������ݳ���
		response.setContentLength(in.available());
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
			out.flush();
		}
		in.close();
	}

}
