<%@ page contentType="text/html; charset=UTF-8" %>

	<%@ include file="navbar.jsp" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="utf-8">
			<title>OverseasConsultancy System</title>

			<!-- Mobile Specific Metas -->
			<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


		</head>

		<body class="form-v2" style="background-color: #607D8B;">
			<div class="container mt-5" >
				<div  class="row justify-content-center">
				<div class="col-md-8">
					<div class="card text-center">
						<div class="card-header text-white" style="background-color: #757575;">
							Select Role For Sign Up
						</div>
						<form action="/select-signup" method="post">
							<div class="card-body" style="background-color: #E0E0E0;">

								<h1 for="formFile" class="form-label"></h1>
								<select class="form-select" name="role">
									<option selected>Select role</option>
									<option value="Consultant">Consultant</option>
									<option value="Student">Student</option>
								</select>


							</div>
							<div class="card-footer text-body-secondary" style="background-color: #E0E0E0;">
								<div class="container mt-2">
									<button class="btn btn-secondary">Get Form</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				</div>
			</div>

		</body>

		</html>