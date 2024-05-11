<%@ page contentType="text/html; charset=UTF-8" %>

	<%@ include file="navbar.jsp" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="utf-8">
			<title>Student Register</title>

			<!-- Mobile Specific Metas -->
			<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


		</head>

		<body class="form-v2" style="background-color: #607D8B;">
			<div class="container">
				<div>
					<div class="col-md-5 offset-md-4">
						<div class="card mt-3">
							<div class="card-header text-center text-white" style="background-color: #757575;">
								<br />
								Student Register
							</div>

							<div class="card-body" style="background-color: #E0E0E0;">
								<form id="student-reg-form">
									<div class="form-group">
										<label for="name">Student Name</label>
										<input name="name" type="text" class="form-control" id="name"
											aria-describedby="emailHelp" placeholder="Enter Student Name" required />
									</div>

									<div class="form-group">
										<label for="emailId">Student Email</label>
										<input name="emailId" type="email" class="form-control" id="emailId"
											aria-describedby="emailHelp" placeholder="Enter email">
										<small id="emailHelp" class="form-text text-muted">We'll never share your
											email with
											anyone else.</small>
									</div>
									<div class="form-group">
										<label for="password">Password</label>
										<input name="password" type="password" class="form-control" id="password"
											aria-describedby="emailHelp" placeholder="Enter Password">
									</div>

									<div class="form-group">
										<label for="specification">Student specification</label>
										<input name="specification" type="text" class="form-control" id="specification"
											aria-describedby="emailHelp" placeholder="Enter Specification">
									</div>
									<div class="mb-3">
										<label for="formFile" class="form-label">Choose profile</label>
										<input class="form-control" type="file" id="profileImg" name="profileImg">
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
					</div>
				</div>
			</div>
			<script>

				$(document).ready(function () {
					$("#student-reg-form").validate({
						rules: {
							name: {
								required: true,
								minlength: 4,
								maxlength: 20,
							},
							emailId: {
								required: true,
								email: true
							},
							password: {
								minlength: 8,
								required: true,
							},
							specification: {
								required: true,
								minlength: 2,

							},
							profileImg: {
								required: true
							},



						},
						messages: {
							name: {
								required: "Please Enter Name",
								minlength: "minimum 4  character require",
								maxlength: "maximum 20 character require"
							}
							,
							emailId: {
								required: "Please enter Email Id",
								email: "Please enter Valid Email"
							},
							password: {
								minlength: "please enter minmum 8 character",
								required: "Please Enter Password"

							},
						},
						submitHandler: function (form) {
							$.ajax({
								enctype: 'multipart/form-data',
								type: "POST",
								url: "/student-data",
								data: new FormData(form),
								processData: false,
								contentType: false,
								cache: false,
								success: function (data) {
									if (data.trim() === 'success') {
										Swal.fire("Good job!", "Successfully register", "success")
											.then((value) => {
												window.location = "/signin";
											});
									} else {
										Swal.fire("Please Try Again ", data);
									}
								},
								error: function (xhr, status, error) {

									console.error("Error:", error);
								}
							});
						}
					});
				});

			</script>
		</body>

		</html>