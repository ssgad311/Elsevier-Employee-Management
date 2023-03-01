<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix = "c" %>
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
				</div>
				<div class="container my-5">
					<p class="my-5">
						<a href="/employee-management/add-employee"
							class="btn btn-primary"> <i class="fas fa-user-plus ml-2">Add
								Employee </i>
						</a>
					</p>
					<%-- <div class="col-md-10">
						<c:if test="${employees.size()==0}">
							<h2>No record found !!</h2>
						</c:if>
						<c:if test="${employees.size() gt 0 }">
							<div>
								<table class="table table-striped table-responsive-md">
									<thead>
										<tr>
											<th>Name</th>
											<th>Address</th>
											<th>Email</th>
											<th>Gender</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="employees" items="${employee}">
											<tr>
												<td>${employee.name}</td>
												<td>${employee.address}</td>
												<td>${employee.emailId}</td>
												<td>${employee.gender}</td>
												<td><a
													href="/employee-management/employee-update/${employee.id}"
													class="btn btn-primary"> <i
														class="fas fa-user-edit ml-2"></i></a></td>
												<td><a
													href="/employee-management/employee-delete/${employee.id}"
													class="btn btn-primary"> <i
														class="fas fa-user-times ml-2"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
					</div> --%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>