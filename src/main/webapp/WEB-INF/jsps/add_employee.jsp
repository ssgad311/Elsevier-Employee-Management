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
		</div>
		<h3>Add Employee</h3>
		<div class="card">
			<div class="card-body">
				<div class="col-md-10">
					<div class="container">
						<div class="row justify-content-center">
							<h5><font color="red">${message}</font></h5>
						</div>
					</div>
					<form:form action="/employee-management/save-employee/${managerId}"
						method="post" modelAttribute="employee" enctype="multipart/form-data">
						<form:hidden path="id" />
						<div class="row">
							<div class="form-group col-md-8">
								<label for="name" class="col-form-label">Name</label>
								<form:input type="text" class="form-control" id="name"
									path="name" placeholder="Name" />
							</div>
							<div class="form-group col-md-8">
								<label for="username" class="col-form-label">User Name</label>
								<form:input type="text" class="form-control" id="username"
									path="username" placeholder="username" />
							</div>
							<div class="form-group col-md-8">
								<label for="password" class="col-form-label">Password</label>
								<form:input type="password" class="form-control" id="password"
									path="password" placeholder="password" />
							</div>
							<div class="form-group col-md-8">
								<label for="department" class="col-form-label">Department</label>
								<form:input type="text" class="form-control" id="department"
									path="department" placeholder="department" />
							</div>
							<div class="form-group col-md-8">
								<label for="designation" class="col-form-label">Designation</label>
								<form:input type="text" class="form-control" id="designation"
									path="designation" placeholder="designation" />
							</div>
							<div class="form-group col-md-8">
								<label for="location" class="col-form-label">Location</label>
								<form:input type="text" class="form-control" id="location"
									path="location" placeholder="location" />
							</div>
							<div class="form-group col-md-8">
								<label for="mobileNo" class="col-form-label">Mobile No</label>
								<form:input type="text" class="form-control" id="mobileNo"
									path="mobileNo" placeholder="mobileNo" />
							</div>
							<div class="form-group col-md-8">
								<label for="email" class="col-form-label">Email</label>
								<form:input type="text" class="form-control" id="email"
									path="emailId" placeholder="Email Id" />
								${emailErrormessage}
							</div>
							<div class="form-group col-md-8">
								<label for="gender" class="col-form-label">Gender</label>
								<div class="form-check">
									<label class="form-check-label" for="radio1"> <input
										type="radio" class="form-check-input" id="radio1"
										name="gender" value="male" checked>Male
									</label>
								</div>
								<div class="form-check">
									<label class="form-check-label" for="radio2"> <input
										type="radio" class="form-check-input" id="radio2"
										name="gender" value="female">Female
									</label>
								</div>

								<%-- <form:input type="text" class="form-control" id="gender"
									path="gender" placeholder="Gender" /> --%>
							</div>
							<div class="form-group col-md-8">
								<label for="salary" class="col-form-label">Salary</label>
								<form:input type="text" class="form-control" id="salary"
									path="salary" placeholder="Salary" />
							</div>
							
							<div class="form-group col-md-8">
								<label for=photos class="col-form-label">Upload Photo</label>
								<input type="file" name="image" accept="image/png, image/jpeg" class="form-control"  path="photos" id="photos" />
							</div>
							
							<%-- <div class="form-group col-md-8">
								<label for="manager" class="col-form-label">Select
									Manager</label> <select name="manager">
									<option value="">--select manager--</option>
									<c:forEach items="${managers}" var="manager">
										<option value="${manager.id}">${manager.name}</option>
									</c:forEach>
								</select>
							</div>
							 --%>
							<div class="col-md-6">
								<input type="submit" class="btn btn-primary" value=" Submit ">
							</div>

							<div class="col-md-6">
								<a href="/employee-management/manager-operations/${managerId}" class="btn btn-primary">Manager Home
								</a>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>