package com.yl.entity;

import java.util.Date;

/**
 * 员工工资类型
 * @author Mr.Yang
 *
 */
public class EmpSalType {
	private int salTypeId;
	private String salTypeName;
	private String salTypeAmount;
	private String salTypeRemark;
	private Date salTypeDate;
	private String salTypeState;
	private String salTypePriority;
	
	public EmpSalType() {
		super();
	}

	public EmpSalType(int salTypeId, String salTypeName, String salTypeAmount,
			String salTypeRemark, Date salTypeDate, String salTypeState,
			String salTypePriority) {
		super();
		this.salTypeId = salTypeId;
		this.salTypeName = salTypeName;
		this.salTypeAmount = salTypeAmount;
		this.salTypeRemark = salTypeRemark;
		this.salTypeDate = salTypeDate;
		this.salTypeState = salTypeState;
		this.salTypePriority = salTypePriority;
	}

	public int getSalTypeId() {
		return salTypeId;
	}

	public void setSalTypeId(int salTypeId) {
		this.salTypeId = salTypeId;
	}

	public String getSalTypeName() {
		return salTypeName;
	}

	public void setSalTypeName(String salTypeName) {
		this.salTypeName = salTypeName;
	}

	public String getSalTypeAmount() {
		return salTypeAmount;
	}

	public void setSalTypeAmount(String salTypeAmount) {
		this.salTypeAmount = salTypeAmount;
	}

	public String getSalTypeRemark() {
		return salTypeRemark;
	}

	public void setSalTypeRemark(String salTypeRemark) {
		this.salTypeRemark = salTypeRemark;
	}

	public Date getSalTypeDate() {
		return salTypeDate;
	}

	public void setSalTypeDate(Date salTypeDate) {
		this.salTypeDate = salTypeDate;
	}

	public String getSalTypeState() {
		return salTypeState;
	}

	public void setSalTypeState(String salTypeState) {
		this.salTypeState = salTypeState;
	}

	public String getSalTypePriority() {
		return salTypePriority;
	}

	public void setSalTypePriority(String salTypePriority) {
		this.salTypePriority = salTypePriority;
	}

}
