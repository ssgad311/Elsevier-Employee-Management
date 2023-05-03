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

	// Manager Operations
	@GetMapping("/mainpage")
	public String welcomPage() {
		return "manager-main-page";
	}
	
	@GetMapping("/")
	public String viewManagerRegistrationPageHomePageForRahul(Model model) {
		model.addAttribute("manager", new Manager());
		return "add_manager";
	}
	
	@GetMapping("/manager-mainpage")
	public String managerMainPage() {
		return "manager-main-page2-for-rahul";
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
			return "add_manager";
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

	@GetMapping("/manager-operations")
	public String managerHomePage() {
		return "manager-operations";
	}

	// Employee Operations

	@GetMapping("/employee-login")
	public String employeeLoginPage(Model model) {
		model.addAttribute("employee", new Manager());
		return "employee-login";
	}

	@PostMapping("/employee-login-action")
	public String loginEmployee(Model model, Employee employee) {
		if (employee.getUsername().isEmpty() && employee.getPassword().isEmpty()) {
			model.addAttribute("message", "Incorrect username or password");
			return "employee-login";
		} else {
			Employee employeeDetails = employeeService.validateUser(employee);
			if (null != employeeDetails) {
				String s = "redirect:/employee-management/employee-operations/"+employeeDetails.getId();
				return s;
			} else {
				model.addAttribute("message", "Username or Password is wrong!!");
				return "employee-login";
			}
		}
	}

	@GetMapping("/employee-operations/{id}")
	public String employeeOperationsHomePageWithId(@PathVariable("id") Integer employeeId,Model model) {
		System.out.println("employeeId :"+employeeId);
		model.addAttribute("employeeId",employeeId);
		return "employee-operations";
	}

	@GetMapping("/employee-veiw-my-tasks/{employeeId}")
	public String employeeViewMyTasks(Model model, @PathVariable("employeeId") Integer employeeId) {
		System.out.println("employee id controller : " + employeeId);
		List<Task> taskList = taskService.getTaskDetailsByEmployeeId(employeeId);
		System.out.println("Employee Task List: " + taskList);
		model.addAttribute("tasks", taskList);
		model.addAttribute("employeeId", employeeId);
		return "employee_task_details";
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

	@GetMapping("/view-all-employees")
	public String listAllEmployees(Model model) {
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addAttribute("employees", employeeList);
		return "employee-details";
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
		return "redirect:/employee-management/view-all-employees";
	}

	

	// Task Operations
	@GetMapping("/add-task")
	public String taskCreationPage(Model model) {
		model.addAttribute("task", new Task());
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addAttribute("employees", employeeList);
		return "add_task";
	}

	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task, Model model) {
		System.out.println("Task Id: " + task.getTaskId());
		if (task.getTaskName().isEmpty()) {
			model.addAttribute("message", "please provide correct task name");
			return "add_task";
		} else {
			taskService.saveTask(task);
			model.addAttribute("message", "Task Created/Updated Successfully!!!");
			return "add_task";
		}
	}
	
	@PostMapping("/save-task/employee")
	public String saveTaskByEmployee(@ModelAttribute Task task, Model model) {
		System.out.println("Task Id: " + task.getTaskId());
		if (task.getTaskName().isEmpty()) {
			model.addAttribute("message", "please provide correct task name");
			return "update-task-employee";
		} else {
			Task taskDetails = taskService.saveTask(task);
			model.addAttribute("employeeId", taskDetails.getEmployee().getId());
			model.addAttribute("message", "Task Created/Updated Successfully!!!");
			return "update-task-employee";
		}
	}

	@GetMapping("/view-all-tasks")
	public String listAllTasks(Model model) {
		List<Task> taskList = taskService.listAllTasks();
		model.addAttribute("tasks", taskList);
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addAttribute("employees", employeeList);
		return "task_details";
	}

	@GetMapping("/task-update/{id}")
	public String updateTaskDetails(@PathVariable("id") Integer id, Model model) {
		Task task = taskService.getById(id);
		model.addAttribute("task", task);
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addAttribute("employees", employeeList);
		return "add_task";
	}	
	
	@GetMapping("/task-update/{id}/{employee_id}")
	public String updateTaskAndEmployeeDetails(@PathVariable("id") Integer id,@PathVariable("employee_id") Integer employeeId, Model model) {
		Task task = taskService.getById(id);
		model.addAttribute("task", task);
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addAttribute("employees", employeeList);
		model.addAttribute("employeeId", employeeId);
		return "update-task-employee";
	}	

	@GetMapping("/task-delete/{id}")
	public String deleteT(@PathVariable("id") Integer id) {
		Task task = taskService.getById(id);
		taskService.delete(task);
		return "redirect:/employee-management/view-all-tasks";
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

}
