package com.yl.entity;
/**
 * ��Ŀ���״̬
 * @author Mr.Yang
 *
 */
public class ProState {
	private int proStateId;
	private String proState;
	
	public ProState() {
		super();
	}

	public ProState(int proStateId, String proState) {
		super();
		this.proStateId = proStateId;
		this.proState = proState;
	}

	public int getProStateId() {
		return proStateId;
	}

	public void setProStateId(int proStateId) {
		this.proStateId = proStateId;
	}

	public String getProState() {
		return proState;
	}

	public void setProState(String proState) {
		this.proState = proState;
	}

}
