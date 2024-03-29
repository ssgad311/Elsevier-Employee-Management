package com.elsevier.elsevier.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elsevier.elsevier.model.Task;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	@Query(
			  value = "SELECT * FROM Task where employee_id = :employeeId order by task_id desc", nativeQuery = true)
	List<Task> findByEmployeeId(@Param("employeeId")Integer employeeId);
	
	@Query(value ="SELECT * FROM Task t WHERE " +
            "t.task_name LIKE CONCAT('%',:name, '%') and t.manager_id = :managerId",nativeQuery = true)
	List<Task> searchWithTaskNameAndManagerID(@Param("name")String name,@Param("managerId")Integer managerId);
	
	@Query(
			  value = "SELECT * FROM Task where manager_id = :managerId order by task_id desc", nativeQuery = true)
	List<Task> findAllTaskByManagerId(@Param("managerId")Integer managerId);
	
	@Query(
			  value = "SELECT * FROM Task where task_id=:taskId and manager_id = :managerId order by task_id desc", nativeQuery = true)
	Task findByTaskIdAndManagerId(@Param("taskId")Integer taskId,@Param("managerId") Integer managerId);
	
	@Query(
			  value = "SELECT * FROM Task where task_id=:taskId and employee_id = :employeeId order by task_id desc", nativeQuery = true)
	Task findByTaskIdAndEmployeeId(@Param("taskId")Integer taskId,@Param("employeeId")Integer employeeId);
	
}
