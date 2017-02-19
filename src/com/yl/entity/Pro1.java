package com.yl.entity;
/**
 *业务要求所需，新创建一个实体类封装项目信息
 * @author Mr.Yang
 *
 */
public class Pro1{
	private int proId;
	private String proName;
	
	public Pro1() {
		super();
	}

	public Pro1(int proId, String proName) {
		super();
		this.proId = proId;
		this.proName = proName;
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

}
