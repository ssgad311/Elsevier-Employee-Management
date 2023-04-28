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
					<div class="col-md-10">
						<c:if test="${tasks.size()==0}">
							<h2>No record found !!</h2>
						</c:if>
						<c:if test="${employees.size() gt 0 }">
							<div>
								<table class="table table-striped table-responsive-md">
									<thead>
										<tr>
											<th>Task Id</th>
											<th>Task Name</th>
											<th>Task Details</th>											
										</tr>
									</thead>
									<tbody>
										<c:forEach var="tasks" items="${task}">
											<tr>
												<td>${task.name}</td>
												<td>${task.address}</td>
												<td>${task.emailId}</td>												
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>