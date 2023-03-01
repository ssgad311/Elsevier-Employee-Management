package com.elsevier.elsevier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.elsevier.elsevier.dao.EmployeeDao;
import com.elsevier.elsevier.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);	
	}

	public Employee getById(Integer id) {
		return employeeDao.getById(id);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
		
	}

	@Override
	public Page<Employee> listAll(int pageNum, String sortField, String sortDir) {
		return employeeDao.listAll(pageNum,sortField,sortDir);
	}

	
}
