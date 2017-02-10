package com.yl.vo;
/**
 * 值对象，封装条件信息
 * @author Mr.Yang
 *
 */
public class ClientVo {
	private String clientcomp;

	public ClientVo() {
		super();
	}

	public ClientVo(String clientcomp) {
		super();
		this.clientcomp = clientcomp;
	}

	public String getClientcomp() {
		return clientcomp;
	}

	public void setClientcomp(String clientcomp) {
		this.clientcomp = clientcomp;
	}
	
	
}
