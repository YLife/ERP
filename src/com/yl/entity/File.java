package com.yl.entity;

import java.util.Date;

/**
 * 封装文件信息
 * @author Mr.Yang
 *
 */
public class File {
	private int fileId;
	private String fileName;
	private Date uploadDate;
	private Emp1 emp1;
	private Pro1 pro1;
	
	public File() {
		super();
	}

	public File(int fileId, String fileName, Date uploadDate, Emp1 emp1,
			Pro1 pro1) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.emp1 = emp1;
		this.pro1 = pro1;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Emp1 getEmp1() {
		return emp1;
	}

	public void setEmp1(Emp1 emp1) {
		this.emp1 = emp1;
	}

	public Pro1 getPro1() {
		return pro1;
	}

	public void setPro1(Pro1 pro1) {
		this.pro1 = pro1;
	}
}
