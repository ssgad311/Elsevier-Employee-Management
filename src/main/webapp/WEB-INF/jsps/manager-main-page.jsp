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
		</div>
		<div class="card">
			<div class="card-body">
				<div class="container my-5">
					<div>
						<p class="my-5">
							<a href="/employee-management/add-manager"
								class="btn btn-primary"> <i class="fas fa-user-plus ml-2">
									Manager Registration</i>
							</a>
						</p>
					</div>
					<div>
						<p class="my-5">
							<a href="/employee-management/manager-login"
								class="btn btn-primary"> <i class="fas fa-user ml-2">
									Login</i>
							</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>