package com.yl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.FileBiz;
import com.yl.biz.ProBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.biz.impl.FileBizImpl;
import com.yl.biz.impl.ProBizImpl;
import com.yl.entity.Emp;
import com.yl.entity.Emp1;
import com.yl.entity.File;
import com.yl.entity.Pro;
import com.yl.entity.Pro1;

public class DoFileUploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileBiz biz = new FileBizImpl();
	private EmpBiz ebiz = new EmpBizImpl();
	private ProBiz pbiz = new ProBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> map = (Map<String, String>) request.getAttribute("map");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Emp emp = ebiz.findById(Integer.parseInt(map.get("empId")));
		Pro pro = pbiz.findById(Integer.parseInt(map.get("proId")));
		Emp1 emp1 = new Emp1(emp.getEmpId(), emp.getEmpName());
		Pro1 pro1 = new Pro1(pro.getProId(), pro.getProName());
		File efile = null;
		try {
			efile = new File(0, map.get("fileName"), sdf.parse("2007-01-01"), emp1, pro1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int row = biz.save(efile);
		if (row > 0 ) {
			System.out.println("ok");
		}
	}

}
