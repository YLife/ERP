package com.yl.entity;
/**
 * 功能信息
 * @author Mr.Yang
 *
 */
public class ProFun {
	private int funId;
	private String funName;
	private int modId;
	private int empId;
	private String remark;
	
	public ProFun() {
		super();
	}

	public ProFun(int funId, String funName, int modId, int empId,
		String remark) {
		super();
		this.funId = funId;
		this.funName = funName;
		this.modId = modId;
		this.empId = empId;
		this.remark = remark;
	}

	public int getFunId() {
		return funId;
	}

	public void setFunId(int funId) {
		this.funId = funId;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
