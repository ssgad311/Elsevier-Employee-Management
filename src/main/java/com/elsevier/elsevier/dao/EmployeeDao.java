package com.elsevier.elsevier.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.elsevier.elsevier.model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();

	Employee saveEmployee(Employee employee);

	Employee getById(Integer id);

	void delete(Employee employee);

	Page<Employee> listAll(int pageNum, String sortField, String sortDir);

}
