package com.yl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.biz.EmpBiz;
import com.yl.biz.EmpSalBiz;
import com.yl.biz.EmpTypeBiz;
import com.yl.biz.impl.EmpBizImpl;
import com.yl.biz.impl.EmpSalBizImpl;
import com.yl.biz.impl.EmpTypeBizImpl;
import com.yl.entity.Emp;
import com.yl.entity.EmpJob;
import com.yl.entity.EmpRole;
import com.yl.entity.EmpSal;
import com.yl.entity.EmpSalState;

public class DoEmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpSalBiz sbiz = new EmpSalBizImpl();
	private EmpBiz biz = new EmpBizImpl();
	private EmpTypeBiz tbiz = new EmpTypeBizImpl();
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
/*		String jobId = request.getParameter("jobId");
*/		String bonus = request.getParameter("bonus");
		String typeId = request.getParameter("typeId");
		String other = request.getParameter("other");
		String baseSal = request.getParameter("baseSal");
		String remark = request.getParameter("remark");
/*		String roleId = request.getParameter("roleId");
*/		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd"); 
		Emp emp = null;
		try {
			emp = new Emp(0, empName, empPwd, empSex, sdf.parse(empBorn), sdf.parse(empDate), empNo, empPhone, tbiz.findById(Integer.parseInt(typeId)) , new EmpJob(1, "程序员"), new EmpRole(1, "员工"), sbiz.findById(empId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		EmpSal es = null;
		try {
			es = new EmpSal(0, Double.parseDouble(baseSal), Double.parseDouble(bonus), 0 , Double.parseDouble(other),"打卡" , sdf.parse("2005-05-01"), remark, Integer.parseInt(empId), new EmpSalState(2, "未发放"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int row = biz.save(emp);
		row += sbiz.save(es);
		if (row == 2) {
			response.sendRedirect("index.jsp");
		}
	}

}
