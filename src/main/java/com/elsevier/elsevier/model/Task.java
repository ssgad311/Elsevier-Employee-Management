package com.elsevier.elsevier.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Integer taskId;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "task_details")
	private String taskDetails;
	
	@Column(name="task_status")
	private String taskStatus;
	
	@Column(name="task_created_date")
	private Timestamp taskCreatedDate;
	
	@Column(name="task_completion_date")
	private String taskCompletionDate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;	
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}

	public Task(int taskId, String taskName, String taskDetails) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDetails = taskDetails;
	}

	public Task() {
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Timestamp getTaskCreatedDate() {
		return taskCreatedDate;
	}

	public void setTaskCreatedDate(Timestamp timestamp) {
		this.taskCreatedDate = timestamp;
	}

	public String getTaskCompletionDate() {
		return taskCompletionDate;
	}

	public void setTaskCompletionDate(String taskCompletionDate) {
		this.taskCompletionDate = taskCompletionDate;
	}

	public Task(Integer taskId, String taskName, String taskDetails, String taskStatus, Timestamp taskCreatedDate,
			String taskCompletionDate, Employee employee) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDetails = taskDetails;
		this.taskStatus = taskStatus;
		this.taskCreatedDate = taskCreatedDate;
		this.taskCompletionDate = taskCompletionDate;
		this.employee = employee;
	}
	
	

}
