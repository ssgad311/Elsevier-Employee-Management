<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Manager Login</title>
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
				<h1 class="form-heading">Employee Management</h1>
			</div>
			<div >
				<h1 class="form-heading">Manager Login</h1>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<div>
					<font color="red">${message}</font>
				</div>
				<form:form action="/employee-management/manager-login-action"
					method="POST" modelAttribute="manager">
					<div class="container my-5">
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
					</div>
					<div>
						<div class="col-md-6">
							<input type="submit" class="btn btn-primary" value="Login ">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>