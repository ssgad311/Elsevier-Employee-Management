<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Employee Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- Import jquery cdn -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous">
	
</script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous">
	
</script>
</head>
<body>
	<div class="container my-2">
		<div class="container my-3">
			<div class="row justify-content-center">
				<h1>Employee Management</h1>
			</div>
			<div class="row justify-content-left">
				<h1>Task Details</h1>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<div class="container my-5">
					<div>
						<c:if test="${tasks.size()==0}">
							<h2>No record found !!</h2>
						</c:if>
						<c:if test="${tasks.size() gt 0 }">
							<div>
								<table class="table table-striped table-responsive-md">
									<thead>
										<tr>
											<th>Task Id</th>
											<th>Name</th>
											<th>Details</th>
											<th>Status</th>
											<th>Assigned Employee</th>
											<th>Created Date</th>
											<th>Completion Date</th>
											<th>Edit</th>
											<th>Delete</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var="task" items="${tasks}">
											<tr>
												<td>${task.taskId}</td>
												<td>${task.taskName}</td>
												<td>${task.taskDetails}</td>
												<td>${task.taskStatus}</td>
												<td>${task.employee.name}</td>
												<td>${task.taskCreatedDate}</td>
												<td>${task.taskCompletionDate}</td>
												<td><a
													href="/employee-management/task-update/${task.taskId}"
													class="btn btn-primary"> Edit</a></td>

												<td><a
													href="/employee-management/task-delete/${task.taskId}"
													class="btn btn-danger">Delete </a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
					</div>
					<div class="col-md-6">
						<a href="/employee-management/manager-operations"
							class="btn btn-primary"> Manager Home </a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>