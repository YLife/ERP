package com.yl.entity;

import java.util.Date;

/**
 * 封装项目模块信息
 * @author Mr.Yang
 *
 */
public class ProMod {
	private int modId;
	private String modName;
	private Pro1 pro1;
	private Emp1 emp1;
	private ModPriority modPriority;
	private Date createDate;
	private Date endDate;
	private String remark;
	
	public ProMod() {
		super();
	}

	public ProMod(int modId, String modName, Pro1 pro1, Emp1 emp1,
			ModPriority modPriority, Date createDate, Date endDate,
			String remark) {
		super();
		this.modId = modId;
		this.modName = modName;
		this.pro1 = pro1;
		this.emp1 = emp1;
		this.modPriority = modPriority;
		this.createDate = createDate;
		this.endDate = endDate;
		this.remark = remark;
	}

	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public Pro1 getPro1() {
		return pro1;
	}

	public void setPro1(Pro1 pro1) {
		this.pro1 = pro1;
	}

	public Emp1 getEmp1() {
		return emp1;
	}

	public void setEmp1(Emp1 emp1) {
		this.emp1 = emp1;
	}

	public ModPriority getModPriority() {
		return modPriority;
	}

	public void setModPriority(ModPriority modPriority) {
		this.modPriority = modPriority;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
