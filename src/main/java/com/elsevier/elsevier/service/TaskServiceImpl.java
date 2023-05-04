package com.elsevier.elsevier.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Task;
import com.elsevier.elsevier.repo.EmployeeRepository;
import com.elsevier.elsevier.repo.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Task> listAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public Task saveTask(Task task) {
		Employee employee = employeeRepository.findById(task.getEmployee().getId()).get();
		if (task.getTaskId() == null) {
			task.setTaskCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
			Task taskDetails = taskRepository.save(task);
			return taskDetails;
		} else {
			Task taskObject = taskRepository.findById(task.getTaskId()).get();
			taskObject.setTaskId(task.getTaskId());
			taskObject.setTaskName(task.getTaskName());
			taskObject.setTaskDetails(task.getTaskDetails());
			taskObject.setEmployee(employee);
			taskObject.setTaskCompletionDate(task.getTaskCompletionDate());
			Task taskDetails = taskRepository.save(task);
			return taskDetails;
		}
	}

	public Task getById(Integer id) {
		return taskRepository.findById(id).get();
	}

	public void delete(Task task) {
		taskRepository.delete(task);

	}

	public List<Task> getTaskDetailsByEmployeeId(Integer employeeId) {
		System.out.println("employeeId : " + employeeId);
		List<Task> taskDetailsOfEmployee = taskRepository.findByEmployeeId(employeeId);
		System.out.println("taskDetailsOfEmployee : " + taskDetailsOfEmployee);
		return taskDetailsOfEmployee;
	}
}
