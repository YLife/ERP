package com.yl.entity;
/**
 *ҵ��Ҫ�����裬�´���һ��ʵ�����װ��Ŀ��Ϣ
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
