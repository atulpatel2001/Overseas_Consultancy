<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ page import="java.util.List" %>
		<%@ page import="com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Appointment" %>
			<%@ page import="com.over.seaes.consultancy.OverseasConsultancyPogramme.modal.Consultant" %>
				<%@ include file="navbar.jsp" %>
					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="utf-8">
						<title>Student | All Appointement</title>
						<!-- Mobile Specific Metas -->
						<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
					</head>

					<body class="form-v2" style="background-color: #607D8B;">
						<div class="container mt-5">
							<div class="mt-2">
								

									<div class="card" style="background-color: #E0E0E0;">
										<div class="card-body text-white text-center" style="background-color: #757575;">
											<h5 class="card-title text-uppercase mb-0">
												Appointement Details
											</h5>
										</div>
										<div class="table-responsive">
											<table class="table no-wrap user-table mb-0">
												<thead>
													<tr>
														<th scope="col"
															class="border-0 text-uppercase font-medium pl-4">
															Consultant Name
														</th>
														<th scope="col"
															class="border-0 text-uppercase font-medium pl-4">
															Appointement Created On
														</th>
														<th scope="col"
															class="border-0 text-uppercase font-medium pl-4">
															Appointement Modifie On
														</th>
														<th scope="col"
															class="border-0 text-uppercase font-medium pl-4">
															Start Time
														</th>
														<th scope="col"
															class="border-0 text-uppercase font-medium pl-4">
															End Time
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
																	<a>
																		<a
																			href="/student/consultant-detail/<%= appointment.getConsultant().getConsultantId() %>">
																			<%= appointment.getConsultant().getName() %>
																		</a>
																	</a>

																</td>
																<td>
																	<div class="text-muted">
																		<%= appointment.getCreated_on() %>
																	</div>
																</td>
																<td>
																	<div class="text-muted">
																		<%= appointment.getModified_on() %>
																	</div>
																</td>
																<td>
																	<div class="text-muted">
																		<%= appointment.getStartTimeDate() %>
																	</div>
																</td>
																<td>
																	<div class="text-muted">
																		<%= appointment.getEndTime() %>
																	</div>
																</td>
																<td>
																	<button type="button"
																		class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2"
																		data-bs-target="#exampleModalToggle-<%= appointment.getAppointmentId() %>"
																		data-bs-toggle="modal">
																		<i class="fa fa-edit"></i>
																	</button>

																	<!-- modal start -->
																	<div class="modal fade"
																		id="exampleModalToggle-<%= appointment.getAppointmentId() %>"
																		aria-hidden="true"
																		aria-labelledby="exampleModalToggleLabel"
																		tabindex="-1">
																		<div class="modal-dialog modal-dialog-centered">
																			<div class="modal-content">
																				<div class="modal-header">
																					<h1 class="modal-title fs-5"
																						id="exampleModalToggleLabel">
																						Change Consultant</h1>
																					<button type="button"
																						class="btn-close"
																						data-bs-dismiss="modal"
																						aria-label="Close"></button>
																				</div>
																				<form class="editconsultant"
																					id="editconsultant-<%= appointment.getAppointmentId() %>">
																					<div class="modal-body">
																						<input type="hidden"
																							value="<%= appointment.getAppointmentId() %>"
																							name="appointmentId">

																						<select class="form-select"
																							aria-label="Default select example"
																							name="consultantId">
																							<option
																								value="<%= appointment.getConsultant().getConsultantId() %>">
																								<%= appointment.getConsultant().getName()
																									%>
																							</option>
																							<% for (Consultant
																								consultant :
																								(List<Consultant>)
																								request.getAttribute("consultants"))
																								{ %>
																								<% if
																									(!consultant.getName().equals(appointment.getConsultant().getName()))
																									{ %>
																									<option
																										value="<%= consultant.getConsultantId() %>">
																										<%= consultant.getName()
																											%>
																									</option>
																									<% } %>
																										<% } %>
																						</select>

																					</div>
																					<div class="modal-footer">
																						<button
																							class="btn btn-primary">Give
																							Schedule</button>
																					</div>

																				</form>
																			</div>
																		</div>
																	</div>


																	<!-- modal end -->
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
							$(document).ready(function () {
								$(document).on('submit', '.editconsultant', function (event) {
									event.preventDefault();


									$.ajax({
										enctype: 'multipart/form-data',
										type: "POST",
										url: "/student/change-consultant",
										data: new FormData(this),
										processData: false,
										contentType: false,
										cache: false,
										success: function (data) {
											if (data.trim() === 'success') {
												Swal.fire("Good job!", "Successfully Change consultant", "success")
													.then((value) => {
														window.location = "/student/all-appointment";
													});
											} else {
												Swal.fire("Please Try Again ", data);
											}
										},
										error: function (xhr, status, error) {

											console.error("Error:", error);
										}
									});

								});
							});
						</script>
					</body>

					</html>