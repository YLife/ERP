package com.yl.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class DoFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = (String)request.getSession().getAttribute("empId");
		Map<String, String> map = new HashMap<String, String>();
		map.put("empId", empId);
		//����FileItemFactory����
		FileItemFactory factory = new DiskFileItemFactory();
		//����ServletFileUpload����
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//����form�е������ļ����ı��ֶκ�ý���ļ���ͳ��Ϊ�ļ���
		List<FileItem> list = new ArrayList<FileItem>();
		try {
			list = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//�����ļ�
		for (FileItem item : list) {
			if (item.isFormField()) {
				map.put(item.getFieldName(), item.getString());
			}else {
				//�õ��ļ���
				String name = item.getName();
				String ex = "";
				//�õ���չ��
				if (name.lastIndexOf(".") != -1) {
					ex = name.substring(name.lastIndexOf("."));
				}
				//��̬���ɷ��������ļ���(�ļ��ϴ����Ǹ߲����ģ����������ֹ����)
				String fName = ""+System.currentTimeMillis() + (int)Math.random()*10000000 + ex; 
				//�������·��
				String filePath = "/files/" + fName;
				//�õ�����·��
				String realPath = request.getSession().getServletContext().getRealPath(filePath);
				//�����ļ�
				File file = new File(realPath);
				try {
					item.write(file);
					request.getRequestDispatcher("DoFileUploadServlet2").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
