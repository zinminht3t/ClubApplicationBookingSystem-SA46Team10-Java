<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>New Facility Form</title>

<spring:url value="/css/FacilityFormNew.css" var="FacilityFormNew" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="assets/css/Data-Table.css">
<link rel="stylesheet" href="assets/css/Data-Table2.css">
<link rel="stylesheet" href="assets/css/Dynamic-Table.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>




<script
			src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
		<script src="js/index.js"></script>
</head>

<body>


	<form>

		<div class="container">

			<br/>
			<br/>
			<br/>
			
			<div class="row">
				<div class="col-md-12 text-center">
					<h3>Booking Confirmed</h3>
				</div>
			</div>	
					
			<hr>		
					
			<div class="row">		
				<div class="col-md-6">
					<div class="panel panel-primary">
	
						
	
						<div class="form-group">
							<label class="control-label col-md-4">Booking Id</label>
							<!-- attribute name -->
							<input class="control-label col-md-4" path="bookingid" value="${booking.getBookingid()}" readonly="readonly"/>
	
						</div>
						
						
						<div class="form-group">
							<label class="control-label col-md-4">Transaction Time</label>
								<!-- attribute name -->
								<input class="control-label col-md-4" path="transactiontime" value="${booking.getTransactiontime()}"/>
						</div>
	
						
						<div class="form-group">
							<label class="control-label col-md-4">User Id</label>
								<!-- attribute name -->
								<input class="control-label col-md-4" path="users" value="${booking.getUser().userId}"/>
						</div>
	
						<div class="form-group">
							<label class="control-label col-md-4">Total ($)</label>
								<!-- attribute name -->
								<input class="control-label col-md-4" path="total" value="${booking.total}"/>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Status</label>
								<!-- attribute name -->
								<input class="control-label col-md-4" path="total" value="${booking.status}"/>
						</div>
				</div>
				
				<div class="col-md-offset-2 col-md-8">
					<div class="panel-heading">
	
						
						<input class ="btn btn-danger" id="btnSubmit" type="submit" value="OK" style="width: 150px;"/>
						
						<hr>
	
					</div>
								
	
					
	
					</div>
	
				</div>
				
				<!-- second column -->
						</div>
		</div>
	</form>
	

	

</body>
