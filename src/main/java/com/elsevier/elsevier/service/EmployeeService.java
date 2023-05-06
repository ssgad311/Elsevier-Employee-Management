package com.elsevier.elsevier.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Manager;
import com.elsevier.elsevier.model.Task;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee saveEmployee(Employee employee);

	Employee getById(Integer id);

	void delete(Employee deleteStaff);

	Page<Employee> listAll(int pageNum, String sortField, String sortDir);
	
	Employee validateUser(Employee employee);
	
	public List<Employee> searchWithEmployeeName(String name, Integer managerId);
	
	List<Employee> getAllEmployeesBasedOnManagerId(Integer managerId);

}
