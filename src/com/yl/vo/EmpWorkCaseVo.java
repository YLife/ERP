package com.yl.vo;
/**
 * 员工工作情况条件信息
 * @author Mr.Yang
 *
 */
public class EmpWorkCaseVo {
	private String first;
	private String second;
	
	public EmpWorkCaseVo() {
		super();
	}

	public EmpWorkCaseVo(String first, String second) {
		super();
		this.first = first;
		this.second = second;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

}
