<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ page import="java.util.List" %>

		<%@ page import="com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Consultant" %>
			<%@ include file="navbar.jsp" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="utf-8">
					<title>Student | Consultant Detail</title>
					<!-- Mobile Specific Metas -->
					<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


				</head>

				<body class="form-v2" style="background-color: #607D8B;">
					<div class="container mt-5">
						<div class="card text-center">
							<div class="card-header " style="background-color: #757575;">
								<h1>Consultant</h1>
							</div>

							<% Consultant consultant=(Consultant)request.getAttribute("consultant"); %>
								<div class="card-body" >
									<div class="row">
										<div class="col-md-6">
											<img src="/image/consltunt-img/<%= consultant.getProfileImg() %>"
												alt="image" class="img-fluid rounded-circle" style="max-height: 200px;">
										</div>
										<div class="col-md-6">
											<table class="table">
												<tbody>
													<tr>
														<th scope="row" style="font-size:16px; font-weight: bold;">
															Consultant Name :</th>
														<td style="font-size:16px;">
															<%= consultant.getName() %>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div style="font-size:16px;">
												<%= consultant.getSpecification() %>
											</div>
										</div>
									</div>

								</div>
						</div>
					</div>


				</body>

				</html>