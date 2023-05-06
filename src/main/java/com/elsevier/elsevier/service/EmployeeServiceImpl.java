package com.elsevier.elsevier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.elsevier.elsevier.dao.EmployeeDao;
import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Manager;
import com.elsevier.elsevier.model.Task;
import com.elsevier.elsevier.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public Employee saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);	
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
	
	@Override
	public Employee validateUser(Employee employee) {
		Employee employeeDetails = employeeRepository.findByUsername(employee.getUsername());
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employeeDetails);
		return employeeList.size() > 0 ? employeeList.get(0) : null;
	}	
	
	public List<Employee> searchWithEmployeeName(String name) {
		return employeeRepository.findByEmployeeName(name);
	}

	
}
