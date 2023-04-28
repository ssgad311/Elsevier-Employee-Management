package com.elsevier.elsevier.controller;

import java.util.List;

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

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Manager;
import com.elsevier.elsevier.model.Task;
import com.elsevier.elsevier.service.EmployeeService;
import com.elsevier.elsevier.service.ManagerService;
import com.elsevier.elsevier.service.TaskService;

@Controller
@RequestMapping(value = "/employee-management")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public String welcomPage() {
		return "manager-main-page";
	}

	@GetMapping("/add-manager")
	public String viewManagerRegistrationPage(Model model) {
		model.addAttribute("manager", new Manager());
		return "add_manager";
	}

	@PostMapping("/save-manager")
	public String saveManager(@ModelAttribute Manager manager, Model model) {
		if (manager.getMailId().contains("@")) {
			managerService.saveManager(manager);
			model.addAttribute("message", "Manager Created/Updated Successfully!!!");
			return "redirect:/employee-management/add-manager";
		} else {
			model.addAttribute("emailErrormessage", "please provide correct email with @ domain");
			return "redirect:/employee-management/add-manager";
		}
	}

	@GetMapping("/manager-login")
	public String managerLoginPage(Model model) {
		model.addAttribute("manager", new Manager());
		return "manager-login";
	}

	@PostMapping("/manager-login-action")
	public String loginManager(Model model, Manager manager) {
		if (manager.getUsername().isEmpty() && manager.getPassword().isEmpty()) {
			model.addAttribute("message", "Incorrect username or password");
			return "manager-login";
		} else {
			Manager managerDetails = managerService.validateUser(manager);
			if (null != managerDetails) {
				return "manager-operations";
			} else {
				model.addAttribute("message", "Username or Password is wrong!!");
				return "manager-login";
			}
		}
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
	
	@GetMapping("/add-task")
	public String taskCreationPage(Model model) {
		model.addAttribute("task", new Task());
		return "add_task";
	}
	
	@GetMapping("/manager-operations")
	public String managerHomePage() {
		return "manager-operations";
	}
	
	@GetMapping("/assign-task-to-employee")
	public String assignTaskToEmployee() {
		return "task_details";
	}	
	
	
	
	

	@GetMapping("/page/{pageNum}")
	public String viewPage(Model model, @PathVariable(name = "pageNum") int pageNum,
			@Param("sortField") String sortField, @Param("sortDir") String sortDir) {
		Page<Employee> page = employeeService.listAll(pageNum, sortField, sortDir);
		List<Employee> employeesList = page.getContent();

		// Pagination
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		// Sorting
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("sortField", sortField);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("employees", employeesList);
		return "welcome";
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

};
