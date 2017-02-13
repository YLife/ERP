package com.yl.entity;
/**
 * 员工职位信息
 * @author Mr.Yang
 *
 */
public class EmpJob {
	private int jobId;
	private String jobName;
	
	public EmpJob() {
		super();
	}

	public EmpJob(int jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}
