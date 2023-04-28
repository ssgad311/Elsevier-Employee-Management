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
						<div class="row">
							<div class="form-group col-md-8">
								<label for="taskName" class="col-form-label">Task Name</label>
								<form:input type="text" class="form-control" id="taskName"
									path="taskName" placeholder="Provide the Task Name" />
							</div>
							<div class="form-group col-md-8">
								<label for="taskDetails" class="col-form-label">Task
									Details</label>
								<form:textarea  cols="10" rows="10" type="text" class="form-control" id="taskDetails"
									path="taskDetails" placeholder="Provide the Task Details" />
							</div>
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