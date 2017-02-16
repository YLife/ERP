package com.yl.entity;

import java.util.Date;

/**
 * 封装任务信息
 * @author Mr.Yang
 *
 */
public class Task {
	private int taskId;
	private String taskName;
	private Pro1 pro1;
	private ProMod1 mod1;
	private ProFun1 fun1;
	private Emp1 emp1;
	private Priority priority;
	private Date createDate;
	private Date endDate;
	private String taskNote; 
	
	public Task() {
		super();
	}

	public Task(int taskId, String taskName, Pro1 pro1, ProMod1 mod1,
			ProFun1 fun1, Emp1 emp1, Priority priority, Date createDate,
			Date endDate, String taskNote) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.pro1 = pro1;
		this.mod1 = mod1;
		this.fun1 = fun1;
		this.emp1 = emp1;
		this.priority = priority;
		this.createDate = createDate;
		this.endDate = endDate;
		this.taskNote = taskNote;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Pro1 getPro1() {
		return pro1;
	}

	public void setPro1(Pro1 pro1) {
		this.pro1 = pro1;
	}

	public ProMod1 getMod1() {
		return mod1;
	}

	public void setMod1(ProMod1 mod1) {
		this.mod1 = mod1;
	}

	public ProFun1 getFun1() {
		return fun1;
	}

	public void setFun1(ProFun1 fun1) {
		this.fun1 = fun1;
	}

	public Emp1 getEmp1() {
		return emp1;
	}

	public void setEmp1(Emp1 emp1) {
		this.emp1 = emp1;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTaskNote() {
		return taskNote;
	}

	public void setTaskNote(String taskNote) {
		this.taskNote = taskNote;
	}

}
