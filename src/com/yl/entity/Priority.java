package com.yl.entity;
/**
 * ”≈œ»º∂
 * @author Mr.Yang
 *
 */
public class Priority {
	private int priorityId;
	private String priorityName;
	
	public Priority() {
		super();
	}

	public Priority(int priorityId, String priorityName) {
		super();
		this.priorityId = priorityId;
		this.priorityName = priorityName;
	}

	public int getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

}
