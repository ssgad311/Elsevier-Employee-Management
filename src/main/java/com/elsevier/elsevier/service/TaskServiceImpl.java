package com.elsevier.elsevier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsevier.elsevier.model.Task;
import com.elsevier.elsevier.repo.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> listAllTasks(){
		return taskRepository.findAll();
	}
}
