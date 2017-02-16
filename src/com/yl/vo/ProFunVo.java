package com.yl.vo;
/**
 * 封装功能条件信息
 * @author Mr.Yang
 *
 */
public class ProFunVo {
	private String funName;

	public ProFunVo() {
		super();
	}

	public ProFunVo(String funName) {
		super();
		this.funName = funName;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

}
