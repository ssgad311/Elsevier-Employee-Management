package com.elsevier.elsevier.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsevier.elsevier.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
