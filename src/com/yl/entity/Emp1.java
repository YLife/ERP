package com.yl.entity;


/**
 * 业务要求所需，新创建一个实体类封装员工信息
 * @author Mr.Yang
 *
 */
public class Emp1{
	private int empId;
	private String empName;
	
	public Emp1() {
		super();
	}

	public Emp1(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
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
}
