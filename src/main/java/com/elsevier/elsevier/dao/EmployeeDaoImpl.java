package com.elsevier.elsevier.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.repo.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll(); 	
	}

	public void saveEmployee(Employee employee) {
		System.out.println("Employee Id : "+employee.getId());
		if(employee.getId()==null) {
			employeeRepository.save(employee);
		}else {
			Employee employeeObject = employeeRepository.findById(employee.getId()).get();
			employeeObject.setName(employee.getName());
			employeeObject.setDepartment(employee.getDepartment());
			employeeObject.setDesignation(employee.getDesignation());
			employeeObject.setLocation(employee.getLocation());
			employeeObject.setMobileNo(employee.getMobileNo());
			employeeObject.setEmailId(employee.getEmailId());
			employeeObject.setGender(employee.getGender());
			employeeObject.setSalary(employee.getSalary());
			employeeRepository.save(employee);
		}
	}

	public Employee getById(Integer id) {
		return employeeRepository.findById(id).get();
	}

	public void delete(Employee employee) {
		employeeRepository.delete(employee);
		
	}

	public Page<Employee> listAll(int pageNum, String sortField, String sortDir) {
		int pageSize = 5;	     
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sortDir.equals("ase")?Sort.by(sortField).ascending():Sort.by(sortField).descending());
	    //System.out.println("Pagable : "+pageable);
	     
	    return employeeRepository.findAll(pageable);
	}

	public List<Employee> employeeListForExportExcel(){
		return employeeRepository.findAll(Sort.by("emailId").ascending());
	}
	
}
