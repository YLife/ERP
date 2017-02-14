package com.yl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.EmpJobBiz;
import com.yl.biz.EmpRoleBiz;
import com.yl.biz.EmpSalBiz;
import com.yl.biz.EmpTypeBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.biz.impl.EmpJobBizImpl;
import com.yl.biz.impl.EmpRoleBizImpl;
import com.yl.biz.impl.EmpSalBizImpl;
import com.yl.biz.impl.EmpTypeBizImpl;
import com.yl.entity.Emp;
import com.yl.entity.EmpJob;
import com.yl.entity.EmpRole;
import com.yl.entity.EmpSal;
import com.yl.entity.EmpType;
public class DoEmpEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpBiz biz = new EmpBizImpl();
	private EmpSalBiz sbiz = new EmpSalBizImpl();
	private EmpTypeBiz tbiz = new EmpTypeBizImpl();
	private EmpJobBiz jbiz = new EmpJobBizImpl();
	private EmpRoleBiz rbiz = new EmpRoleBizImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String empId = request.getParameter("empId");
		String empPwd = request.getParameter("empPwd");
		String empName = request.getParameter("empName");
		String empSex = request.getParameter("empSex");
		String empBorn = request.getParameter("empBorn");
		String empNo = request.getParameter("empNo");
		String empPhone = request.getParameter("empPhone");
		String empDate = request.getParameter("empDate");
		String jobId = request.getParameter("jobId");
		String bonus = request.getParameter("bonus");
		String typeId = request.getParameter("typeId");
		String other = request.getParameter("other");
		String baseSal = request.getParameter("baseSal");
		String remark = request.getParameter("remark");
		String roleId = request.getParameter("roleId");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		EmpType et = tbiz.findById(Integer.parseInt(typeId));
		EmpJob ej = jbiz.findById(Integer.parseInt(jobId));
		EmpRole er = rbiz.findById(Integer.parseInt(roleId));
		EmpSal es = sbiz.findById(Integer.parseInt(empId));
		System.out.println(es);
		System.out.println(baseSal);
		es.setBaseSal(Double.parseDouble(baseSal));
		es.setBonus(Double.parseDouble(bonus));
		es.setOther(Double.parseDouble(other));
		es.setRemark(remark);
		int row = sbiz.update(es);
		Emp emp = null;
		try {
			emp = new Emp(Integer.parseInt(empId), empName, empPwd, empSex, sdf.parse(empBorn), sdf.parse(empDate), empNo, empPhone, et, ej, er, es);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		row += biz.update(emp);
		if (row == 2) {
			response.sendRedirect("EmpServlet");
		}
	}

}
