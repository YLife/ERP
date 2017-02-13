package com.yl.entity;

import java.util.Date;

/**
 * 工资信息
 * @author Mr.Yang
 *
 */
public class EmpSal {
	private int salId;
	private double baseSal ; 
	private double bonus;
	private double fine;
	private double other;
	private String salType;
	private Date salDate;
	private String remark;
	private int empId;
	private EmpSalState salState;
	public EmpSal() {
		super();
	}
	public EmpSal(int salId, double baseSal, double bonus, double fine,
			double other, String salType, Date salDate, String remark,
			int empId, EmpSalState salState) {
		super();
		this.salId = salId;
		this.baseSal = baseSal;
		this.bonus = bonus;
		this.fine = fine;
		this.other = other;
		this.salType = salType;
		this.salDate = salDate;
		this.remark = remark;
		this.empId = empId;
		this.salState = salState;
	}
	public int getSalId() {
		return salId;
	}
	public void setSalId(int salId) {
		this.salId = salId;
	}
	public double getBaseSal() {
		return baseSal;
	}
	public void setBaseSal(double baseSal) {
		this.baseSal = baseSal;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public double getOther() {
		return other;
	}
	public void setOther(double other) {
		this.other = other;
	}
	public String getSalType() {
		return salType;
	}
	public void setSalType(String salType) {
		this.salType = salType;
	}
	public Date getSalDate() {
		return salDate;
	}
	public void setSalDate(Date salDate) {
		this.salDate = salDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public EmpSalState getSalState() {
		return salState;
	}
	public void setSalState(EmpSalState salState) {
		this.salState = salState;
	}
}
