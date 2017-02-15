package com.yl.entity;

/**
 * 封装模块优先级信息
 * @author Mr.Yang
 *
 */
public class ModPriority {
	private int modPriorityId;
	private String modPriorityName;
	
	public ModPriority() {
		super();
	}
	
	public ModPriority(int modPriorityId, String modPriorityName) {
		super();
		this.modPriorityId = modPriorityId;
		this.modPriorityName = modPriorityName;
	}
	public int getModPriorityId() {
		return modPriorityId;
	}
	public void setModPriorityId(int modPriorityId) {
		this.modPriorityId = modPriorityId;
	}
	public String getModPriorityName() {
		return modPriorityName;
	}
	public void setModPriorityName(String modPriorityName) {
		this.modPriorityName = modPriorityName;
	}

}
