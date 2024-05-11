<%@ page contentType="text/html; charset=UTF-8" %>

	<%@ include file="navbar.jsp" %>

		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="UTF-8">
			<title>Login</title>
		</head>

		<body style="background-color: #607D8B;">
			<main class="p-5">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-md-6">
							<div class="card" id="card-border">
								<div class="card-header text-center text-white" style="background-color: #757575;">

									<br>
									<h3>Login</h3>
								</div>


								<% if (request.getParameter("error") !=null) { %>
									<div class="alert alert-danger">
										Invalid UserName or Password
									</div>
									<% } %>

										<% if (request.getParameter("logout") !=null) { %>
											<div class="alert alert-success">
												You have been logged out!!
											</div>
											<% } %>


												<div class="card-body" style="background-color: #E0E0E0;">
													<form id="reg-form" action="/doLogin" method="post">
														<div class="form-group">
															<label for="customerEmailId">Email Id</label>
															<input id="customerEmailId" type="text"
																placeholder="Enter Email" name="username"
																class="form-control">
														</div>
														<div class="form-group">
															<label for="customerPassword">Password</label>
															<input id="customerPassword" type="password"
																placeholder="Enter Password" name="password"
																class="form-control">
														</div>


														<div class="container text-center mt-2">
															<input type="submit" value="Login"
																class="btn btn-success btn-lg">
														</div>

													</form>


												</div>
							</div>
						</div>
					</div>
				</div>
			</main>



		</body>

		</html>