package com.elsevier.elsevier.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elsevier.elsevier.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
