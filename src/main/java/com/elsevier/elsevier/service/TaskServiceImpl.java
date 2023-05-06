package com.elsevier.elsevier.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public List<Task> listAllTasks(Integer managerId) {
		return taskRepository.findAllTaskByManagerId(managerId);
	}

	@Override
	public Task saveTask(Task task) {
		Employee employee = employeeRepository.findById(task.getEmployee().getId()).get();
		if (task.getTaskId() == null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
			LocalDateTime now = LocalDateTime.now();
			task.setTaskCreatedDate(dtf.format(now));
			SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
			task.setTaskCompletionDate(s.format(new Date().parse(task.getTaskCompletionDate())));
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

	public Task getByTaskIdAndManagerId(Integer taskId, Integer managerId) {
		return taskRepository.findByTaskIdAndManagerId(taskId,managerId);
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
	
	public List<Task> searchWithTaskNameAndManagerID(String name,Integer managerId) {
		return taskRepository.searchWithTaskNameAndManagerID(name,managerId);
	}

	@Override
	public Task getByTaskIdAndEmployeeId(Integer taskId, Integer employeeId) {
		return taskRepository.findByTaskIdAndEmployeeId(taskId,employeeId);
	}
	
}
