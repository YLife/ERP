package com.yl.entity;


/**
 * ҵ��Ҫ�����裬�´���һ��ʵ�����װԱ����Ϣ
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
