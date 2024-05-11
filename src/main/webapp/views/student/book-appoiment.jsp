<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ page import="java.util.List" %>
		<%@ page import="com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Consultant" %>
			<%@ include file="navbar.jsp" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="utf-8">
					<title>Book Appoiment</title>

					<!-- Mobile Specific Metas -->
					<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


				</head>

				<body class="form-v2" style="background-color: #607D8B;">
					<div class="container mt-5">
						<div class="mt-2">
							
								<div class="card" style="background-color: #E0E0E0;">
									<div class="card-body" style="background-color: #757575;">
										<h5 class="card-title text-uppercase mb-0 text-center text-white" >
											Book Consultant
										</h5>
									</div>
									<div class="table-responsive mt-2" style="background-color: #E0E0E0;">
										<table class="table no-wrap user-table mb-0" >
											<thead >
												<tr>
													<th scope="col" class="border-0 text-uppercase font-medium pl-4">
														Consultant Name
													</th>
													<th scope="col" class="border-0 text-uppercase font-medium pl-4">
														Consultant Specification
													</th>
														<th scope="col" class="border-0 text-uppercase font-medium pl-4">
                                                    		Accept Booking
                                                    	</th>

												</tr>
											</thead>

											<tbody style="background-color: #E0E0E0;">
												<% List<Consultant> consultants = (List<Consultant>)
														request.getAttribute("consultants");
														for (Consultant consultant : consultants) {
														%>
														<tr>
															<td class="pl-4">
																<a
																style="text-decoration: none;"
																	href="/student/consultant-detail/<%= consultant.getConsultantId() %>">
																	<%= consultant.getName() %>
																</a>

															</td>
															<td>
																<div class="text-muted">
																	<%= consultant.getSpecification() %>
																</div>
															</td>








															<td>
																<button type="button"
																	class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2"
																	onclick="book(<%= consultant.getConsultantId() %>)">
																	<i class="fas fa-calendar-check"></i>
																</button>

															</td>
														</tr>

														<% } %>

											</tbody>

										</table>


									</div>

								</div>
							
						</div>
					</div>


					<script>
						function book(consultantId) {
							$.ajax({
								type: 'POST',
								url: "/student/book-appointment",
								data: { consultantId: consultantId },
								success: function (data, textStatus, jqXHR) {
									if (data.trim() === 'success') {
										Swal.fire("Good job!", "Successfully Booked Appointment", "success");
									} else {
										Swal.fire("Please Try Again", data);
									}
								},
								error: function (jqXHR, textStatus, errorThrown) {
									console.log(jqXHR);
									Swal.fire("Something Went Wrong !!! Try Again!!");
								}
							});
						}

					</script>
				</body>

				</html>