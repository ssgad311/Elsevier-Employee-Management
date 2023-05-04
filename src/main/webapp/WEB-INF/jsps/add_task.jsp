<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Add Employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>

<body>
	<div class="container my-5">
		<div class="container my-3">
			<div class="row justify-content-center">
				<h1>Employee Management</h1>
			</div>
			<div>
				<h2>Add Task</h2>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<div class="col-md-10">
					<div class="container">
						<div class="row justify-content-center">
							<h5>${message}</h5>
						</div>
					</div>
					<form:form action="/employee-management/save-task" method="post"
						modelAttribute="task">
						<form:hidden path="taskId" />
						<div class="row">
							<div class="form-group col-md-8">
								<label for="taskName" class="col-form-label">Task Name</label>
								<form:input type="text" class="form-control" id="taskName"
									path="taskName" placeholder="Provide the Task Name" />
							</div>
							<div class="form-group col-md-8">
								<label for="taskDetails" class="col-form-label">Task
									Details</label>
								<form:textarea cols="10" rows="10" type="text"
									class="form-control" id="taskDetails" path="taskDetails"
									placeholder="Provide the Task Details" />
							</div>
							<div class="form-group col-md-8">
								<label for="taskStatus" class="col-form-label">Task
									Status</label> <select name="taskStatus">
									<option value="">--select status--</option>
									<option value="Open">Open</option>
									<option value="Work In Progress">Work In Progress</option>
									<option value="Pending">Pending</option>
									<option value="Closed">Closed</option>
								</select>
							</div>

							<div class="form-group col-md-8">
								<label for="employee" class="col-form-label">Select
									Employee</label> <select name="employee">
									<option value="">--select employee--</option>
									<c:forEach items="${employees}" var="employee">
										<option value="${employee.id}">${employee.name}</option>
									</c:forEach>
								</select>
							</div>

							<div class="form-group col-md-8">
								<label for="taskCompletionDate" class="col-form-label">Completion
									Date</label>
								<form:input type="text" class="form-control" id="datepicker"
									path="taskCompletionDate"
									placeholder="Provide the Task completion date" />
							</div>
							<script>
								$(function() {
									$.datepicker.setDefaults({
										onClose : function(date, inst) {
											$("#selectedDtaeVal").html(date);
										}
									});
									$("#datepicker").datepicker();
								});
							</script>

							<div class="col-md-6">
								<input type="submit" class="btn btn-primary" value=" Submit ">
							</div>

							<div class="col-md-6">
								<a href="/employee-management/manager-operations"
									class="btn btn-primary"> Manager Home </a>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>