package com.yl.entity;
/**
 * ҵ��Ҫ������ �����·�װ������Ϣ
 * @author Mr.Yang
 *
 */
public class ProFun1 {
	private int funId;
	private String funName;
	public ProFun1() {
		super();
	}
	
	public ProFun1(int funId, String funName) {
		super();
		this.funId = funId;
		this.funName = funName;
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

}
