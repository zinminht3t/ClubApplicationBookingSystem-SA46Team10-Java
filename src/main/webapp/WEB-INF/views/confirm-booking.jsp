
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
.accordion-toggle:after {
	font-family: 'FontAwesome';
	content: "\f078";
	float: right;
}

.accordion-opened .accordion-toggle:after {
	content: "\f054";
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<spring:url value="/js/confirm-booking.js" var="javascript" />
<script src="${javascript}"></script>

<spring:url value="/css/confirm-booking-style.css" var="style" />
<link rel="stylesheet" href="${style}">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {

		$("#datepicker").datepicker({
			dateFormat : 'yy-mm-dd',
			onSelect : function(select) {
				updateAb(select);
			}
		});
		function updateAb(value) {
			window.location
					.replace('${pageContext.request.contextPath}/facilities/confirm-booking/'
							+ value + '/${facilityname}');
		}

	});
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/facilities/confirm-booking">Confirm
		your Booking</a>

	<div class="container">
		<div class="row main">
			<div class="main-login main-center" style="max-width: 650px">
				<h5>Confirm your booking</h5>
				<form:form method="POST"
					action="${pageContext.request.contextPath}/facilities/confirm-booking/booking-details">

					<div class="form-group">
						<label for="datepicker" class="cols-sm-2 control-label">Select
							your booking date</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"
									aria-hidden="true"></i></span> <input type="text" name="selecteddate"
									class="form-control" placeholder="EnterDate" value="${date}"
									id="datepicker">
							</div>
						</div>
					</div>


					<script>
						$(function() {
							$("input").checkboxradio();
						});
					</script>


					<c:forEach var="courts" items="${availableCourtsTime}">
						<c:forEach var="court" items="${courts.key}">

							<div
								style="min-width: 450; background-color: #71bfe5; padding: 5px; margin: 8px; border-radius: 5px; min-height: 33px; opacity: 0.9;">
								<h5
									style="display: block; float: none; margin: 0 auto; height: 20px; line-height: 20px; text-align: center;">
									${court}</h5>

								<div class="container" style="margin: 5px;">
									<div class="row">
										<div class="col-md-4">
											<c:forEach var="time" items="${availableCourtsTime[court]}">
												<div style="margin: 5px; display: inline">
													<span class="button-checkbox">
														<button type="button" class="btn" data-color="success"
															style="margin: 5px;">${time.getTime()}</button> <input
														type="checkbox" name="${court}" value="${time.getTime()}"
														class="hidden">
													</span>
												</div>

											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:forEach>


					<script type="text/javascript">
						$(function() {
							$('.button-checkbox')
									.each(
											function() {

												// Settings
												var $widget = $(this), $button = $widget
														.find('button'), $checkbox = $widget
														.find('input:checkbox'), color = $button
														.data('color'), settings = {
													on : {
														icon : 'glyphicon glyphicon-check'
													},
													off : {
														icon : 'glyphicon glyphicon-unchecked'
													}
												};

												// Event Handlers
												$button
														.on(
																'click',
																function() {
																	$checkbox
																			.prop(
																					'checked',
																					!$checkbox
																							.is(':checked'));
																	$checkbox
																			.triggerHandler('change');
																	updateDisplay();
																});
												$checkbox.on('change',
														function() {
															updateDisplay();
														});

												// Actions
												function updateDisplay() {
													var isChecked = $checkbox
															.is(':checked');

													// Set the button's state
													$button.data('state',
															(isChecked) ? "on"
																	: "off");

													// Set the button's icon
													$button
															.find('.state-icon')
															.removeClass()
															.addClass(
																	'state-icon '
																			+ settings[$button
																					.data('state')].icon);

													// Update the button's color
													if (isChecked) {
														$button
																.removeClass(
																		'btn-default')
																.addClass(
																		'btn-'
																				+ color
																				+ ' active');
													} else {
														$button
																.removeClass(
																		'btn-'
																				+ color
																				+ ' active')
																.addClass(
																		'btn-default');
													}
												}

												// Initialization
												function init() {

													updateDisplay();

													// Inject the icon if applicable
													if ($button
															.find('.state-icon').length == 0) {
														$button
																.prepend('<i class="state-icon '
																		+ settings[$button
																				.data('state')].icon
																		+ '"></i>');
													}
												}
												init();
											});
						});
					</script>


					<div class="form-group ">
						<input type="submit" id="button"
							class="btn btn-primary btn-lg btn-block login-button">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>






<!--  
	<c:forEach var="courts" items="${bookedCourtsTime}">
		<c:forEach var="court" items="${courts.key}">
			${court} <br />
			<c:forEach var="time" items="${bookedCourtsTime[court]}">
					${time.getTimeslots().getTime()} <br />
			</c:forEach>
		</c:forEach>
	</c:forEach>
	-->