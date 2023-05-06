package com.elsevier.elsevier.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.elsevier.elsevier.model.Employee;
import com.elsevier.elsevier.model.Manager;
import com.elsevier.elsevier.model.Task;
import com.elsevier.elsevier.repo.TaskRepository;
import com.elsevier.elsevier.service.EmployeeService;
import com.elsevier.elsevier.service.ManagerService;
import com.elsevier.elsevier.service.TaskService;
import com.elsevier.elsevier.utils.FileUploadUtil;
import com.elsevier.elsevier.utils.URLConstants;

@Controller
@RequestMapping(value = URLConstants.EMPLOYEE_MANAGEMENT)
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ManagerService managerService;

	@Autowired
	private TaskService taskService;

	/*
	 * // Manager Operations
	 * 
	 * @GetMapping("/mainpage") public String welcomPage() { return
	 * "manager-main-page"; }
	 */

	@GetMapping(URLConstants.HOME)
	public String viewManagerRegistrationPageHomePageForRahul(Model model) {
		model.addAttribute("manager", new Manager());
		return "add_manager";
	}

	@GetMapping(URLConstants.MANAGER_HOME_PAGE_TEMP)
	public String managerMainPage() {
		return "manager-main-page2-for-rahul";
	}

	@GetMapping(URLConstants.ADD_MANAGER)
	public String viewManagerRegistrationPage(Model model) {
		model.addAttribute("manager", new Manager());
		return "add_manager";
	}

	@PostMapping(URLConstants.SAVE_MANAGER)
	public String saveManager(@ModelAttribute Manager manager, Model model) {
		if (manager.getMailId().contains("@")) {
			managerService.saveManager(manager);
			model.addAttribute("message", "Manager Created/Updated Successfully!!!");
			return "add_manager";
		} else {
			model.addAttribute("message", "please provide correct email with @ domain");
			return "add_manager";
		}
	}

	@GetMapping(URLConstants.MANAGER_LOGIN)
	public String managerLoginPage(Model model) {
		model.addAttribute("manager", new Manager());
		return "manager-login";
	}

	@PostMapping(URLConstants.MANAGER_LOGIN_ACTION)
	public String loginManager(Model model, Manager manager) {
		if (manager.getUsername().isEmpty() && manager.getPassword().isEmpty()) {
			model.addAttribute("message", "Please provide the username and password");
			return "manager-login";
		} else {
			Manager managerDetails = managerService.validateUser(manager);
			if (null != managerDetails) {
				return "redirect:/employee-management/manager-operations/" + managerDetails.getId();
			} else {
				model.addAttribute("message", "Username or Password is wrong!!");
				return "manager-login";
			}
		}
	}

	@GetMapping(URLConstants.MANAGER_OPERATIONS)
	public String managerHomePage(@PathVariable("managerId") Integer managerId, Model model) {
		model.addAttribute("managerId", managerId);
		return "manager-operations";
	}

	// Employee Operations

	@GetMapping(URLConstants.EMPLOYEE_LOGIN)
	public String employeeLoginPage(Model model) {
		model.addAttribute("employee", new Manager());
		return "employee-login";
	}

	@PostMapping(URLConstants.EMPLOYEE_LOGIN_ACTION)
	public String loginEmployee(Model model, Employee employee) {
		if (employee.getUsername().isEmpty() && employee.getPassword().isEmpty()) {
			model.addAttribute("message", "Incorrect username or password");
			return "employee-login";
		} else {
			Employee employeeDetails = employeeService.validateUser(employee);
			if (null != employeeDetails) {
				String s = "redirect:/employee-management/employee-operations/" + employeeDetails.getId();
				return s;
			} else {
				model.addAttribute("message", "Username or Password is wrong!!");
				return "employee-login";
			}
		}
	}

	@GetMapping(URLConstants.EMPLOYEE_OPERATIONS)
	public String employeeOperationsHomePageWithId(@PathVariable("id") Integer employeeId, Model model) {
		System.out.println("employeeId :" + employeeId);
		model.addAttribute("employeeId", employeeId);
		return "employee-operations";
	}

	@GetMapping(URLConstants.EMPLOYEE_SECIFIC_TASKS)
	public String employeeViewMyTasks(Model model, @PathVariable("employeeId") Integer employeeId) {
		System.out.println("employee id controller : " + employeeId);
		List<Task> taskList = taskService.getTaskDetailsByEmployeeId(employeeId);
		System.out.println("Employee Task List: " + taskList);
		model.addAttribute("tasks", taskList);
		model.addAttribute("employeeId", employeeId);
		return "employee_task_details";
	}

	@GetMapping(URLConstants.ADD_EMPLOYEE)
	public String getAllEmployees(Model model, @PathVariable("managerId") Integer managerId) {
		model.addAttribute("employee", new Employee());
		// List<Manager> managerList = managerService.getAllManagersList();
		// model.addAttribute("managers", managerList);
		model.addAttribute("managerId", managerId);
		return "add_employee";
	}

	@PostMapping(URLConstants.SAVE_EMPLOYEE)
	public String saveEmployee(@ModelAttribute Employee employee, Model model,
			@RequestParam("image") MultipartFile multipartFile, @PathVariable("managerId") Integer managerId)
			throws IOException {
		if (employee.getEmailId().contains("@")) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			employee.setPhotos(fileName);
			Manager managerDetails = managerService.findByManagerId(managerId);
			employee.setManager(managerDetails);
			Employee savedEmployee = employeeService.saveEmployee(employee);
			String uploadDir = "user-photos/" + savedEmployee.getId();
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
			model.addAttribute("message", "Employee Created/Updated Successfully!!!");
			model.addAttribute("managerId", managerId);
			return "add_employee";
		} else {
			model.addAttribute("message", "please provide correct email with @ domain");
			return "add_employee";
		}
	}

	@GetMapping(URLConstants.VIEW_ALL_EMPLOYEES)
	public String viewAllEmployees(Model model, @PathVariable("managerId") Integer managerId) {
		List<Employee> employeeList = employeeService.getAllEmployeesBasedOnManagerId(managerId);
		model.addAttribute("employees", employeeList);
		model.addAttribute("managerId", managerId);
		return "employee-details";
	}

	@GetMapping(URLConstants.EMPLOYEE_UPDATE)
	public String getEmployee(@PathVariable("id") Integer employeeId, Model model,
			@PathVariable("managerId") Integer managerId) {
		Employee employee = employeeService.getById(employeeId);
		model.addAttribute("employee", employee);
		// model.addAttribute("image", employee.getPhotos());
		model.addAttribute("managerId", managerId);
		return "add_employee";
	}

	@GetMapping(URLConstants.EMPLOYEE_DELETE)
	public String deleteEmployee(@PathVariable("employeeId") Integer employeeId,
			@PathVariable("managerId") Integer managerId) {
		Employee employee = employeeService.getById(employeeId);
		List<Task> taskList = taskService.getTaskDetailsByEmployeeId(employeeId);
		for (Task task : taskList) {
			taskService.delete(task);
		}
		System.out.println("sssssssssssssssssssss");
		employeeService.delete(employee);
		return "redirect:/employee-management/view-all-employees/" +managerId;
	}

	@GetMapping(URLConstants.EMPLOYEE_SEARCH)
	public String employeeSearch(@RequestParam("employeeName") String name, Model model,
			@PathVariable("managerId") Integer managerId) {
		List<Employee> employeeList = employeeService.searchWithEmployeeName(name, managerId);
		model.addAttribute("employees", employeeList);
		return "employee-details";
	}
	
	@GetMapping(URLConstants.EMPLOYEE_TASK_UPDATE)
	public String updateTaskAndEmployeeDetails(@PathVariable("taskId") Integer taskId,

			@PathVariable("employee_id") Integer employeeId, Model model) {
		Task task = taskService.getByTaskIdAndEmployeeId(taskId,employeeId);
		model.addAttribute("task", task);
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addAttribute("employees", employeeList);
		model.addAttribute("employeeId", employeeId);
		return "update-task-employee";
	}

	// Task Operations
	@GetMapping(URLConstants.ADD_TASK)
	public String taskCreationPage(Model model, @PathVariable("managerId") Integer managerId) {
		model.addAttribute("task", new Task());
		List<Employee> employeeList = employeeService.getAllEmployeesBasedOnManagerId(managerId);
		model.addAttribute("employees", employeeList);
		model.addAttribute("managerId", managerId);
		return "add_task";
	}

	@PostMapping(URLConstants.SAVE_TASK)
	public String saveTask(@ModelAttribute Task task, Model model, @PathVariable("managerId") Integer managerId) {
		System.out.println("Task Id: " + task.getTaskId());
		if (task.getTaskName().isEmpty()) {
			model.addAttribute("message", "please provide correct task name");
			model.addAttribute("managerId", managerId);
			return "add_task";
		} else {
			Manager managerDetails = managerService.findByManagerId(managerId);
			task.setManager(managerDetails);
			taskService.saveTask(task);
			model.addAttribute("message", "Task Created/Updated Successfully!!!");
			model.addAttribute("managerId", managerId);
			return "add_task";
		}
	}

	@PostMapping(URLConstants.SAVE_EMPLOYEE_TASK)
	public String saveTaskByEmployee(@ModelAttribute Task task, Model model,@PathVariable("employeeId") Integer employeeId) {
		System.out.println("Task Id: " + task.getTaskId());
		if (task.getTaskName().isEmpty()) {
			model.addAttribute("message", "please provide correct task name");
			model.addAttribute("employeeId", "employeeId");
			return "update-task-employee";
		} else {			
			Task task1 = taskService.getByTaskIdAndEmployeeId(task.getTaskId(), employeeId);
			Manager manager = managerService.findByManagerId(task1.getManager().getId());
			task.setManager(manager);
			Task taskDetails = taskService.saveTask(task);
			model.addAttribute("employeeId", taskDetails.getEmployee().getId());
			model.addAttribute("message", "Task Created/Updated Successfully!!!");			
			return "update-task-employee";
		}
	}

	@GetMapping(URLConstants.VIEW_ALL_TASKS)
	public String listAllTasks(Model model, @PathVariable("managerId") Integer managerId) {
		List<Task> taskList = taskService.listAllTasks(managerId);
		model.addAttribute("tasks", taskList);
		List<Employee> employeeList = employeeService.getAllEmployees();
		model.addAttribute("employees", employeeList);
		model.addAttribute("managerId", managerId);
		return "task_details";
	}

	@GetMapping(URLConstants.TASK_UPDATE)
	public String updateTaskDetails(@PathVariable("taskId") Integer taskId, Model model,
			@PathVariable("managerId") Integer managerId) {
		Task task = taskService.getByTaskIdAndManagerId(taskId, managerId);
		model.addAttribute("task", task);
		List<Employee> employeeList = employeeService.getAllEmployeesBasedOnManagerId(managerId);
		model.addAttribute("employees", employeeList);
		return "add_task";
	}
	

	@GetMapping(URLConstants.TASK_DELETE)
	public String deleteTask(@PathVariable("taskId") Integer taskId, @PathVariable("managerId") Integer managerId) {
		Task task = taskService.getByTaskIdAndManagerId(taskId, managerId);
		taskService.delete(task);
		return "redirect:/employee-management/view-all-tasks/" + managerId;
	}

	@GetMapping(URLConstants.TASK_SEARCH)
	public String taskSearch(@RequestParam("taskName") String name, Model model,
			@PathVariable("managerId") Integer managerId) {
		System.out.println("Name : " + name);
		List<Task> taskList = taskService.searchWithTaskNameAndManagerID(name, managerId);
		System.out.println("List fo task : " + taskList.size());
		model.addAttribute("tasks", taskList);
		return "task_details";
	}
	
	
	
	
	
	
	
	
	
	//Paggin and sorting

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
