package com.yl.vo;

import java.util.Date;

/**
 * 封装查询条件信息
 * @author Mr.Yang
 *
 */
public class EmpVo {
	private Date begin;
	private Date end;
	
	public EmpVo() {
		super();
	}

	public EmpVo(Date begin, Date end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	
}
