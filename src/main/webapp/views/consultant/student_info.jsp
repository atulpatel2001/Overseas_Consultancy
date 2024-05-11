<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ page import="java.util.List" %>

		<%@ page import="com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Student" %>
			<%@ include file="navbar.jsp" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="utf-8">
					<title>Consultant | Student Detail</title>

					<!-- Mobile Specific Metas -->
					<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


				</head>

				<body class="form-v2" style="background-color: #607D8B;">
					<div class="container mt-5">
						<div class="card text-center">
							<div class="card-header text-white" style="background-color: #757575;">
								<h1>Student</h1>
							</div>

							<% Student student=(Student)request.getAttribute("student"); %>
								<div class="card-body" >
									<div class="row">
										<div class="col-md-6">
											<img src="/image/student-img/<%= student.getProfileImg() %>" alt="image"
												class="img-fluid rounded-circle" style="max-height: 200px;">
										</div>
										<div class="col-md-6">
											<table class="table" style="background-color: #E0E0E0;">
												<tbody>
													<tr >
														<th scope="row" style="font-size:16px; font-weight: bold;">
															Student Name :</th>
														<td style="font-size:16px;">
															<%= student.getName() %>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div style="font-size:16px;">
												<%= student.getSpecification() %>
											</div>
										</div>
									</div>

								</div>
						</div>
					</div>


				</body>

				</html>