package com.elsevier.elsevier.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elsevier.elsevier.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	@Query(
			  value = "SELECT * FROM Task where employee_id = :employeeId order by task_id desc", nativeQuery = true)
	List<Task> findByEmployeeId(Integer employeeId);
}
