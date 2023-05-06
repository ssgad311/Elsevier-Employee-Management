package com.elsevier.elsevier.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Manager;
import com.elsevier.elsevier.model.Task;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByUsername(String username);
	
	@Query(value ="SELECT * FROM Employee t WHERE " +
            "t.employee_name LIKE CONCAT('%',:name, '%')",nativeQuery = true)
	List<Employee> findByEmployeeName(String name);

}
