package com.elsevier.elsevier.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elsevier.elsevier.excel.EmployeeExcelExport;
import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee-management")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String welcomPage(Model model) {
		/*List<Employee> allEmployees = employeeService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		*/return viewPage(model,1,"name","asc");
	}
	
	@GetMapping("/page/{pageNum}")
	public String viewPage(Model model,@PathVariable(name = "pageNum") int pageNum,@Param("sortField") String sortField,@Param("sortDir") String sortDir) {
		Page<Employee> page = employeeService.listAll(pageNum,sortField,sortDir);
		List<Employee> employeesList = page.getContent();
		
		//Pagination
		model.addAttribute("currentPage", pageNum);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    
	    //Sorting
	    model.addAttribute("sortDir",sortDir);
	    model.addAttribute("sortField",sortField);
	    model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");
	    
	    model.addAttribute("employees", employeesList);
		return "welcome";
	}

	@GetMapping("/add-employee")
	public String getAllEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		return "add_employee";
	}

	@PostMapping("/save-employee")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {
		if (employee.getEmailId().contains("@")) {
			employeeService.saveEmployee(employee);
			model.addAttribute("message", "Employee Created/Updated Successfully!!!");
			return "add_employee";
		} else {
			model.addAttribute("emailErrormessage", "please provide correct email with @ domain");
			return "add_employee";
		}
	}

	@GetMapping("/employee-update/{id}")
	public String getEmployee(@PathVariable("id") Integer id, Model model) {
		Employee employee = employeeService.getById(id);
		model.addAttribute("employee", employee);
		return "add_employee";
	}

	@GetMapping("/employee-delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getById(id);
		employeeService.delete(employee);
		return "redirect:/employee-management/";
	}
	
	@GetMapping("/export-excel")
	public String exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateAndTime = dateFormat.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename = Employees_"+currentDateAndTime+".xlsx";
		response.setHeader(headerKey, headerValue);
		
		List<Employee> employeeListForExportExcel = employeeService.employeeListForExportExcel();
		EmployeeExcelExport employeeExcelExport = new EmployeeExcelExport(employeeListForExportExcel);
		
		employeeExcelExport.export(response);
		
		return "welcome";
	}

};
