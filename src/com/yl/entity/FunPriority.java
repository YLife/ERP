package com.yl.entity;
/**
 * ��װ���ܿ����ȼ���Ϣ
 * @author Mr.Yang
 *
 */
public class FunPriority {
	private int funPriorityId;
	private String funPriorityName;
	
	public FunPriority() {
		super();
	}
	
	public FunPriority(int funPriorityId, String funPriorityName) {
		super();
		this.funPriorityId = funPriorityId;
		this.funPriorityName = funPriorityName;
	}
	public int getFunPriorityId() {
		return funPriorityId;
	}
	public void setFunPriorityId(int funPriorityId) {
		this.funPriorityId = funPriorityId;
	}
	public String getFunPriorityName() {
		return funPriorityName;
	}
	public void setFunPriorityName(String funPriorityName) {
		this.funPriorityName = funPriorityName;
	}

}
