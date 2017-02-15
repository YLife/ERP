package com.yl.vo;
/**
 * 封装条件信息
 * @author Mr.Yang
 *
 */
public class ProModVo {
	private String begin;
	private String end;
	
	public ProModVo() {
		super();
	}

	public ProModVo(String begin, String end) {
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
