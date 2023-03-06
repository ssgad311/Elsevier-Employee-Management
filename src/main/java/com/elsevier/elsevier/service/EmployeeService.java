package com.elsevier.elsevier.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.elsevier.elsevier.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee saveEmployee(Employee employee);

	Employee getById(Integer id);

	void delete(Employee deleteStaff);

	Page<Employee> listAll(int pageNum, String sortField, String sortDir);

	List<Employee> employeeListForExportExcel();

}
