package com.yl.entity;
/**
 * 工资发放状态信息
 * @author Mr.Yang
 *
 */
public class EmpSalState {
	private int salStateId;
	private String salState;
	
	public EmpSalState() {
		super();
	}

	public EmpSalState(int salStateId, String salState) {
		super();
		this.salStateId = salStateId;
		this.salState = salState;
	}

	public int getSalStateId() {
		return salStateId;
	}

	public void setSalStateId(int salStateId) {
		this.salStateId = salStateId;
	}

	public String getSalState() {
		return salState;
	}

	public void setSalState(String salState) {
		this.salState = salState;
	}
}
