package com.elsevier.elsevier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="task_id")
	Integer taskId;
	
	@Column(name="task_name")
	String taskName;
	
	@Column(name="task_details")
	String taskDetails;
	
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
	
	
}
