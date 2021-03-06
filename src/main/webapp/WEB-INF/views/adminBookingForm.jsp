<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>New Facility Form</title>

<spring:url value="/css/FacilityFormNew.css" var="FacilityFormNew" />


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/index.js"></script>
</head>

<body>


	<form:form method="POST" commandName="adminBookingF"
		action="${pageContext.request.contextPath}/admin/viewBookings/editBooking/${booking.getBookingid()}">

		<div class="container">

			<br /> <br /> <br />

			<div class="row">
				<div class="col-md-12 text-center">
					<h3>Edit Booking</h3>
				</div>
			</div>

			<hr>

			<div class="row">
				<div class="col-md-6">
					<div class="panel panel-primary">



						<div class="form-group">
							<label class="control-label col-md-4">Booking Id</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="bookingid"
								value="${booking.getBookingid()}" readonly="readonly"
								disabled="true" />

						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Transaction Time</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="transactiontime"
								value="${booking.getTransactiontime()}" disabled="true" />
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">User Id</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="users"
								value="${booking.getUser().userId}" disabled="true" />
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Total ($)</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="total"
								value="${booking.total}" disabled="true" />
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Status</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="total"
								value="${booking.status}" disabled="true" />
						</div>
					</div>

					<div class="col-md-offset-2 col-md-8">
						<div class="panel-heading">


							<input class="btn btn-danger" id="btnSubmit" type="submit"
								value="Cancel Booking" style="width: 150px;" />

							<hr>

						</div>




					</div>

				</div>

				<!-- second column -->
				<div class="col-md-6">
					<table id="example" class="table table-striped table-bordered"
						cellspacing="0" width="100%">
						<thead>
							<tr class="listHeading">

								<th>Facility Id</th>
								<th>Facility Name</th>
								<th>Timeslot</th>
								<th>Booked Date</th>
								<th>Price ($)</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="bookingDetail" items="${booking.getBookings()}">

								<tr class="bookingDetail">
									<td>${bookingDetail.getFacility().getFacilityID()}</td>
									<td>${bookingDetail.getFacility().getFacilityName()}</td>
									<td>${bookingDetail.getTimeslots().getTime()}</td>
									<td>${bookingDetail.getBookingdate()}</td>
									<td>${bookingDetail.getBookingprice()}</td>
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</form:form>

	<script>
		$( function() {
		    $( "#datepicker_start" ).datepicker(         
		    		dateFormat: 'yyyy-mm-dd',
		            defaultDate: '2018-06-01')
		  });
		  
		$( function() {
		    $( "#datepicker_end" ).datepicker(dateFormat : "dd/mm/yy");
		});	  
	</script>



</body>