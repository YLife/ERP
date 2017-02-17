package com.yl.entity;

import java.util.Date;
/**
 * 封装消息信息
 * @author Mr.Yang
 *
 */
public class Mess {
	private int messId;
	private String messTitle;
	private String messContent;
	private String sendName;
	private String getName;
	private Date sendDate;
	private Date getDate;
	
	public Mess() {
		super();
	}

	public Mess(int messId, String messTitle, String messContent,
			String sendName, String getName, Date sendDate, Date getDate) {
		super();
		this.messId = messId;
		this.messTitle = messTitle;
		this.messContent = messContent;
		this.sendName = sendName;
		this.getName = getName;
		this.sendDate = sendDate;
		this.getDate = getDate;
	}

	public int getMessId() {
		return messId;
	}

	public void setMessId(int messId) {
		this.messId = messId;
	}

	public String getMessTitle() {
		return messTitle;
	}

	public void setMessTitle(String messTitle) {
		this.messTitle = messTitle;
	}

	public String getMessContent() {
		return messContent;
	}

	public void setMessContent(String messContent) {
		this.messContent = messContent;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getGetName() {
		return getName;
	}

	public void setGetName(String getName) {
		this.getName = getName;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

}
