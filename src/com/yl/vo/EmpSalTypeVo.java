package com.yl.vo;
/**
 * 员工工资类型条件信息
 * @author Mr.Yang
 *
 */
public class EmpSalTypeVo {
	private String begin;
	private String end;
	
	public EmpSalTypeVo() {
		super();
	}

	public EmpSalTypeVo(String begin, String end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
}
