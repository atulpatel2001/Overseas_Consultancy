<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ page import="java.util.List" %>
		<%@ page import="com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Appointment" %>
			<%@ page import="com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Student" %>
				<%@ include file="navbar.jsp" %>
					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="utf-8">
						<title>Consultant | DashBoard</title>

						<!-- Mobile Specific Metas -->
						<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


					</head>

					<body class="form-v2" style="background-color: #607D8B;">
						<div class="container">
							<div class="mt-2">
								

									<div class="card" style="background-color: #E0E0E0;">
										<div class="card-body text-center text-white" style="background-color: #757575;">
											<h5 class="card-title text-uppercase mb-0">
												Check Consulting Request
											</h5>
										</div>
										<div class="table-responsive">
											<table class="table no-wrap user-table mb-0">
												<thead>
													<tr>
														<th scope="col"
															class="border-0 text-uppercase font-medium pl-4">
															Student Name
														</th>
														<th scope="col"
															class="border-0 text-uppercase font-medium pl-4">
															Appointement Created On
														</th>
														<th scope="col"
															class="border-0 text-uppercase font-medium pl-4">
															Action
														</th>

													</tr>
												</thead>

												<tbody>
													<% List<Appointment> appointments = (List<Appointment>)
															request.getAttribute("appointments");
															for (Appointment appointment : appointments) {
															%>
															<tr>
																<td class="pl-4">
																	<a
																		href="/consultant/studentDetail/<%= appointment.getStudent().getStudentId() %>">
																		<%= appointment.getStudent().getName() %>
																	</a>

																</td>
																<td>
																	<div class="text-muted">
																		<%= appointment.getCreated_on() %>
																	</div>
																</td>


																<td>
																	<button type="button"
																		class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2"
																		onclick="accept(<%= appointment.getAppointmentId() %>)">
																		<i class="fa fa-check"></i>
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
							function accept(appointmentId) {
								$.ajax({
									type: 'POST',
									url: "/consultant/book-appointment-accept",
									data: { appointmentId: appointmentId },
									success: function (data, textStatus, jqXHR) {
										if (data.trim() === 'success') {
											Swal.fire("Good job!", "Successfully Accept Appointment", "success");
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