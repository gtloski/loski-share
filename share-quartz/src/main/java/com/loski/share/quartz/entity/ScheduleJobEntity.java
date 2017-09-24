package com.loski.share.quartz.entity;

import java.util.Date;

public class ScheduleJobEntity {

	@SuppressWarnings("compatibility:-3671481739452934411")

	private static final long serialVersionUID = 1L;

	public ScheduleJobEntity() {
		super();
	}

	public ScheduleJobEntity(String jobId, String beanName, String methodName, String params, String cronExpression,
			Integer status, String remark, Date createTime) {
		super();
		this.jobId = jobId;
		this.beanName = beanName;
		this.methodName = methodName;
		this.params = params;
		this.cronExpression = cronExpression;
		this.status = status;
		this.remark = remark;
		this.createTime = createTime;
	}

	/**
	 * 任务调度参数key
	 */
	public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

	/**
	 * 任务id
	 */
	private String jobId;

	/**
	 * 类的全路径
	 */
	private String beanName;

	/**
	 * 方法名
	 */
	private String methodName;

	/**
	 * 参数
	 */
	private String params;

	/**
	 * cron表达式
	 */
	private String cronExpression;

	/**
	 * 任务状态
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 设置：任务id
	 * 
	 * @param jobId
	 *            任务id
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * 获取：任务id
	 * 
	 * @return Long
	 */
	public String getJobId() {
		return jobId;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 设置：任务状态
	 * 
	 * @param status
	 *            任务状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：任务状态
	 * 
	 * @return String
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置：cron表达式
	 * 
	 * @param cronExpression
	 *            cron表达式
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
	 * 获取：cron表达式
	 * 
	 * @return String
	 */
	public String getCronExpression() {
		return cronExpression;
	}

	/**
	 * 设置：创建时间
	 * 
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 * 
	 * @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
