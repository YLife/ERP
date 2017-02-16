package com.yl.vo;
/**
 * 封装任务条件信息
 * @author Mr.Yang
 *
 */
public class TaskVo {
	private String begin;
	private String end;
	
	public TaskVo() {
		super();
	}
	
	public TaskVo(String begin, String end) {
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
