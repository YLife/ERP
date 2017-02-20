package com.yl.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

import com.yl.biz.EmpBiz;
import com.yl.biz.FileBiz;
import com.yl.biz.ProBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.biz.impl.FileBizImpl;
import com.yl.biz.impl.ProBizImpl;
import com.yl.entity.Emp;
import com.yl.entity.Emp1;
import com.yl.entity.Files;
import com.yl.entity.Pro;
import com.yl.entity.Pro1;

public class DoFileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileBiz biz = new FileBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	private ProBiz pbiz = new ProBizImpl();
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empId = (String)request.getSession().getAttribute("empId");
		Map<String, String> map = new HashMap<String, String>();
		//����FileItemFactory����
		FileItemFactory factory = new DiskFileItemFactory();
		//����ServletFileUpload����
		ServletFileUpload sfu = new ServletFileUpload(factory);
		//����form�е������ļ����ı��ֶκ�ý���ļ���ͳ��Ϊ�ļ���
		List<FileItem> list = new ArrayList<FileItem>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			list = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//�����ļ�
		for (FileItem item : list) {
			if (item.isFormField()) {
				map.put(item.getFieldName(), new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
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
				System.out.println(map.get("fileName"));
				try {
					item.write(file);
					Emp emp = ebiz.findById(Integer.parseInt(empId));
					Pro pro = pbiz.findById(Integer.parseInt(map.get("proId")));
					Emp1 emp1 = new Emp1(emp.getEmpId(), emp.getEmpName());
					Pro1 pro1 = new Pro1(pro.getProId(), pro.getProName());
					Files files = new Files(0, fName, sdf.parse("2007-01-01"), emp1, pro1);
					int row = biz.save(files);
					if (row > 0) {
						response.getWriter().print("<script>alert('�ϴ��ɹ���');window.location.href='index.jsp'</script>");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
