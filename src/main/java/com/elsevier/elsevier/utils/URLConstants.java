package com.elsevier.elsevier.utils;

public final class URLConstants {

	public static final String EMPLOYEE_MANAGEMENT = "/employee-management";

	public static final String HOME = "/";

	/* Manager Details */
	public static final String MANAGER_HOME_PAGE_TEMP = "/manager-mainpage";
	public static final String ADD_MANAGER = "/add-manager";
	public static final String SAVE_MANAGER = "/save-manager";
	public static final String MANAGER_LOGIN = "/manager-login";
	public static final String MANAGER_LOGIN_ACTION = "/manager-login-action";
	public static final String MANAGER_OPERATIONS = "/manager-operations/{managerId}";

	public static final String EMPLOYEE_LOGIN = "/employee-login";
	public static final String EMPLOYEE_LOGIN_ACTION = "/employee-login-action";
	public static final String EMPLOYEE_OPERATIONS = "/employee-operations/{id}";
	public static final String EMPLOYEE_SECIFIC_TASKS = "/employee-veiw-my-tasks/{employeeId}";
	public static final String ADD_EMPLOYEE = "/add-employee/{managerId}";
	public static final String SAVE_EMPLOYEE = "/save-employee/{managerId}";
	public static final String VIEW_ALL_EMPLOYEES = "/view-all-employees/{managerId}";
	public static final String EMPLOYEE_UPDATE = "/employee-update/{managerId}/{id}";
	public static final String EMPLOYEE_DELETE = "/employee-delete/{managerId}/{employeeId}";
	public static final String EMPLOYEE_SEARCH = "/employee-search/{managerId}";
	public static final String EMPLOYEE_TASK_UPDATE = "/employee-task-update/{taskId}/{employee_id}";

	public static final String ADD_TASK = "/add-task/{managerId}";
	public static final String SAVE_TASK = "/save-task/{managerId}";
	public static final String SAVE_EMPLOYEE_TASK = "/save-task/employee/{employeeId}";
	public static final String VIEW_ALL_TASKS = "/view-all-tasks/{managerId}";
	public static final String TASK_UPDATE = "/task-update/{managerId}/{taskId}";
	public static final String TASK_DELETE = "/task-delete/{managerId}/{taskId}";
	public static final String TASK_SEARCH = "/task-search/{managerId}";

}
