<%@ page contentType="text/html; charset=UTF-8" %>

	<%@ include file="navbar.jsp" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="utf-8">
			<title>Consultant | Change Password</title>

			<!-- Mobile Specific Metas -->
			<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


		</head>

		<body class="form-v2" style="background-color: #607D8B;">

			<main class="p-5">
				<div class="container">
					<div class="col-md-7" style="margin: auto;">

						<div class="container text-white text-center" style="background-color: #757575;font-size: 35px;">
							<div>Change Password</div>
						</div>
						<form id="forgot" style="background-color: #E0E0E0; padding: 5px;">

							<div class="form-group">
								<label for="password">Old Password</label>
								<input name="opassword" type="password" class="form-control" id="opassword"
									aria-describedby="emailHelp" placeholder="Enter old  Password">
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<input name="password" type="password" class="form-control" id="password"
									aria-describedby="emailHelp" placeholder="Enter Password">
							</div>

							<div class="form-group">
								<label for="cPassword">Confirm Password</label>
								<input name="cPassword" type="password" class="form-control" id="cPassword"
									aria-describedby="emailHelp" placeholder="Retype Password">
							</div>

							<div class="container text-center mt-3">
								<button type="submit" class="btn btn-primary" id="submit-btn">
									Submit
								</button>
								<button type="reset" class="btn btn-warning" id="reset-btn">
									Reset
								</button>
							</div>
						</form>

					</div>

				</div>
			</main>

			<script>
				$(document).ready(function () {
					$("#forgot").validate({
						rules: {
							password: {
								required: true,
								minlength: 8,
							},
							oPassword: {
								required: true,
							},
							cPassword: {
								required: true,
							},
						},
						messages: {
							password: {
								required: "Please Enter Password",
								minlength: "minimum 8  character require",
							},
							opassword: {
								required: "Please Enter Password",
								minlength: "minimum 8  character require",
							},
						},
						submitHandler: function (form) {
							let password = $('#password').val();
							let confirmPassword = $('#cPassword').val();

							console.log(password);
							console.log(confirmPassword)
							if (password.trim() !== confirmPassword.trim()) {
								Swal.fire('Password does not match?',
									'Try Again',
									'question'
								);
							} else {
								$.ajax({
									enctype: 'multipart/form-data',
									url: "/consultant/password",
									type: 'POST',
									data: new FormData(form),
									processData: false,
									contentType: false,
									cache: false,
									success: function (data, textStatus, jqXHR) {
										if (data.trim() === 'success') {
											Swal.fire("Good job!", "SuccessFully Change Password", "success")
												.then((value) => {
													window.location = "/consultant/index";
												});
										} else {
											Swal.fire("Please Try Again ", data);
										}
									},
									error: function (jqXHR, textStatus, errorThrown) {
										console.log(jqXHR);
										Swal.fire("Something Went Wrong !!! Try Again!!");
									},

								});
							}
						}
					});
				});

			</script>





		</body>

		</html>