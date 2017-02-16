package com.yl.entity;
/**
 * 封装项目模块信息
 * @author Mr.Yang
 *
 */
public class ProMod1 {
	private int modId;
	private String modName;
	private Pro1 pro1;
	
	public ProMod1() {
		super();
	}

	public ProMod1(int modId, String modName, Pro1 pro1) {
		super();
		this.modId = modId;
		this.modName = modName;
		this.pro1 = pro1;
	}

	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public Pro1 getPro1() {
		return pro1;
	}

	public void setPro1(Pro1 pro1) {
		this.pro1 = pro1;
	}

}
