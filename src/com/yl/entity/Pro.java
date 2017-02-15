package com.yl.entity;

import java.util.Date;

/**
 * 项目信息
 * @author Mr.Yang
 *
 */
public class Pro {
	private int proId;
	private String proName;
	private Double proAmount;
	private Client client;
	private Emp emp;
	private int devNum;
	private Date createDate;
	private Date startDate;
	private Date endDate;
	private Double proCost;
	private String remark;
	private Priority priority;
	private ProState proState;
	
	public Pro() {
		super();
	}

	public Pro(int proId, String proName, Double proAmount, Client client,
			Emp emp, int devNum, Date createDate, Date startDate, Date endDate,
			Double proCost, String remark, Priority priority, ProState proState) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proAmount = proAmount;
		this.client = client;
		this.emp = emp;
		this.devNum = devNum;
		this.createDate = createDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.proCost = proCost;
		this.remark = remark;
		this.priority = priority;
		this.proState = proState;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Double getProAmount() {
		return proAmount;
	}

	public void setProAmount(Double proAmount) {
		this.proAmount = proAmount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public int getDevNum() {
		return devNum;
	}

	public void setDevNum(int devNum) {
		this.devNum = devNum;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getProCost() {
		return proCost;
	}

	public void setProCost(Double proCost) {
		this.proCost = proCost;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public ProState getProState() {
		return proState;
	}

	public void setProState(ProState proState) {
		this.proState = proState;
	}

}
