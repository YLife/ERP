package com.yl.entity;

import java.util.Date;

/**
 * 功能信息
 * @author Mr.Yang
 *
 */
public class ProFun {
	private int funId;
	private String funName;
	private ProMod1 mod1;
	private Emp1 emp1;
	private FunPriority funPriority;
	private Date createDate;
	private String remark;
	
	public ProFun() {
		super();
	}

	public ProFun(int funId, String funName, ProMod1 mod1, Emp1 emp1,
			FunPriority funPriority, Date createDate, String remark) {
		super();
		this.funId = funId;
		this.funName = funName;
		this.mod1 = mod1;
		this.emp1 = emp1;
		this.funPriority = funPriority;
		this.createDate = createDate;
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

	public ProMod1 getMod1() {
		return mod1;
	}

	public void setMod1(ProMod1 mod1) {
		this.mod1 = mod1;
	}

	public Emp1 getEmp1() {
		return emp1;
	}

	public void setEmp1(Emp1 emp1) {
		this.emp1 = emp1;
	}

	public FunPriority getFunPriority() {
		return funPriority;
	}

	public void setFunPriority(FunPriority funPriority) {
		this.funPriority = funPriority;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
