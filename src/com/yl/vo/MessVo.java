package com.yl.vo;
/**
 * 封装消息条件信息
 * @author Mr.Yang
 *
 */
public class MessVo {
	private String begin;
	private String end;
	
	public MessVo() {
		super();
	}

	public MessVo(String begin, String end) {
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
