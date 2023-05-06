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
		<div class="card">
			<div class="card-body">
				<div class="container my-3">
					<div class="row justify-content-center">
						<h1>Employee Management</h1>
					</div>
					<div>
						<h2 class="form-heading">Employee Details</h2>
					</div>
				</div>
				<div class="container my-5">
					<p class="my-5">
						<a href="/employee-management/add-employee/${managerId}"
							class="btn btn-primary"> <i class="fas fa-user-plus ml-2">Add
								Employee </i>
						</a>
					</p>
					<div class="col-md-10">
						<c:if test="${employees.size()==0}">
							<h2>No record found !!</h2>
						</c:if>
						<c:if test="${employees.size() gt 0 }">
							<form action="/employee-management/employee-search/${managerId}">
								<label for="employeeName" class="col-form-label"><b>
										Search Task : </b></label> &nbsp; <input type="text" name="employeeName"
									size="50" id="employeeName"
									placeholder="search with employee name" />&nbsp; <input
									type="submit" value="Search" />&nbsp;
							</form>
							<div>
								<table class="table table-striped table-responsive-md">
									<thead>
										<tr>
											<th>Id</th>
											<th>Name</th>
											<th>Department</th>
											<th>Designation</th>
											<th>Location</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="employee" items="${employees}">
											<tr>
												<td>${employee.id}</td>
												<td>${employee.name}</td>
												<td>${employee.department}</td>
												<td>${employee.designation}</td>
												<td>${employee.location}</td>
												<td><a
													href="/employee-management/employee-update/${managerId}/${employee.id}"
													class="btn btn-primary"> <i
														class="fas fa-user-edit ml-2"></i></a></td>
												<td><a
													href="/employee-management/employee-delete/${managerId}/${employee.id}"
													class="btn btn-primary"> <i
														class="fas fa-user-times ml-2"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
					</div>
					<div class="col-md-6">
						<a href="/employee-management/manager-operations/${managerId}"
							class="btn btn-primary"> Manager Home </a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>