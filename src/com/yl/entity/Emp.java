package com.yl.entity;

import java.util.Date;

/**
 * 员工信息
 * @author Mr.Yang
 *
 */
public class Emp {
	private int empId;
	private String empName;
	private String empPwd;
	private String empSex;
	private Date empBorn;
	private Date empDate;
	private String empNo;
	private String empPhone;
	private EmpType empType;
	private EmpJob empJob;
	private EmpRole empRole;
	private EmpSal empSal;
	
	public Emp() {
		super();
	}

	public Emp(int empId, String empName, String empPwd, String empSex,
			Date empBorn, Date empDate, String empNo, String empPhone,
			EmpType empType, EmpJob empJob, EmpRole empRole, EmpSal empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPwd = empPwd;
		this.empSex = empSex;
		this.empBorn = empBorn;
		this.empDate = empDate;
		this.empNo = empNo;
		this.empPhone = empPhone;
		this.empType = empType;
		this.empJob = empJob;
		this.empRole = empRole;
		this.empSal = empSal;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public Date getEmpBorn() {
		return empBorn;
	}

	public void setEmpBorn(Date empBorn) {
		this.empBorn = empBorn;
	}

	public Date getEmpDate() {
		return empDate;
	}

	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public EmpType getEmpType() {
		return empType;
	}

	public void setEmpType(EmpType empType) {
		this.empType = empType;
	}

	public EmpJob getEmpJob() {
		return empJob;
	}

	public void setEmpJob(EmpJob empJob) {
		this.empJob = empJob;
	}

	public EmpRole getEmpRole() {
		return empRole;
	}

	public void setEmpRole(EmpRole empRole) {
		this.empRole = empRole;
	}

	public EmpSal getEmpSal() {
		return empSal;
	}

	public void setEmpSal(EmpSal empSal) {
		this.empSal = empSal;
	}
	
}
