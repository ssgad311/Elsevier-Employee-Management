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
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css'>
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
					<%-- <div class="container">
						<div class="row justify-content-center">
							<h6><p class="text-success">							
								Sorted by ${sortField} in ${sortDir} order
								</p>
							</h6>
						</div>
					</div> --%>
					<div class="col-md-10">
						<c:if test="${employees.size()==0}">
							<h2>No record found !!</h2>
						</c:if>
						<c:if test="${employees.size() gt 0 }">
							<div>
								<table class="table table-striped table-responsive-md">
									<thead>
										<tr>
											<th>Name</th>
											<th>Department</th>
											<th>Designation</th>
											<th>Location</th>
											<th>Mobile No</th>
											<th>Email Id</th>
											<th>Gender</th>
											<th>Salary
												<button type="button" class="btn btn-link">
													<span class="bi bi-caret-up-fill" style="font-size: 10px; color:rgb(0, 0, 128);"></span></button>
												<button type="button" class="btn btn-link">
													<span class="bi bi-caret-down-fill" style="font-size: 10px; color:rgb(0, 0, 128);"></span></button>
											</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="employee" items="${employees}">
											<tr>
												<td>${employee.name}</td>
												<td>${employee.department}</td>
												<td>${employee.designation}</td>
												<td>${employee.location}</td>
												<td>${employee.mobileNo}</td>
												<td>${employee.emailId}</td>
												<td>${employee.gender}</td>
												<td>${employee.salary}</td>
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
					</div>
					<div>
						<ul class="pagination pg-blue justify-content-center">
							<li class="page-item"><a class="page-link"
								class="link-primary">Total Items : ${totalItems}</a></li>
							<li class="page-item"><a class="page-link"
								href="/employee-management/page/1" class="link-primary">First</a></li>
							<li class="page-item"><a class="page-link"
								href="/employee-management/page/${currentPage - 1}"
								class="link-primary">Previous</a></li>
							<c:forEach begin="1" end="${totalPages}" varStatus="loop">
								<li class="page-item"><a class="page-link"
									href="/employee-management/page/${loop.index}"
									class="link-primary">${loop.index}</a></li>
							</c:forEach>

							<li class="page-item"><a class="page-link"
								href="/employee-management/page/${currentPage + 1}"
								class="link-primary">Next</a></li>
							<li class="page-item"><a class="page-link"
								href="/employee-management/page/${totalPages}"
								class="link-primary">Last</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>