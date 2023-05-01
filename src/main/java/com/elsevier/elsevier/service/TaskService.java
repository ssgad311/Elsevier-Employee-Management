package com.elsevier.elsevier.service;

import java.util.List;

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Task;

public interface TaskService {

	public List<Task> listAllTasks();

	public Task saveTask(Task task);

	public Task getById(Integer id);

	public void delete(Task task);

	public List<Task> getTaskDetailsByEmployeeId(Integer employeeId);
}
