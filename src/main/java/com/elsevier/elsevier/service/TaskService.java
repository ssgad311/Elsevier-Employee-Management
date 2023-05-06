package com.elsevier.elsevier.service;

import java.util.List;

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Task;

public interface TaskService {

	public List<Task> listAllTasks(Integer managerId);

	public Task saveTask(Task task);

	public Task getByTaskIdAndManagerId(Integer taskId, Integer managerId);

	public void delete(Task task);

	public List<Task> getTaskDetailsByEmployeeId(Integer employeeId);
	
	public List<Task> searchWithTaskNameAndManagerID(String name,Integer managerId);
	
	public Task getByTaskIdAndEmployeeId(Integer taskId,Integer employeeId);
}
