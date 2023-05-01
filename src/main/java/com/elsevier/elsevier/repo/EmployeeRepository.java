package com.elsevier.elsevier.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Manager;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByUsername(String username);

}
