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


	<form>

		<div class="container">

			<br /> <br /> <br />

			<div class="row">
				<div class="col-md-12 text-center">
					<h3>Booking Confirmed</h3>
					<h3>Facility Name: ${testSession}</h3>
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
								value="${booking.getBookingid()}" readonly="readonly" />

						</div>


						<div class="form-group">
							<label class="control-label col-md-4">Transaction Time</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="transactiontime"
								value="${booking.getTransactiontime()}" />
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">User Id</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="users"
								value="${booking.getUser().userId}" />
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Total ($)</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="total"
								value="${booking.total}" />
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Status</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="total"
								value="${booking.status}" />
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
								<th>Booked Date</th>
								<th>Price ($)</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="bookingDetail" items="${bookingDetailsList}">

								<tr class="bookingDetail">
									<td>${bookingDetail.getFacilityid()}</td>
									<td>${bookingDetail.getBookingdate()}</td>
									<td>${bookingDetail.getBookingprice()}</td>
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</div>
				
			</div>
		</div>
	</form>


</body>