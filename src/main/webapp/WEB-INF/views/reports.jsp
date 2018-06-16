<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>reports</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="fonts/font-awesome.min.css">
    <link rel="stylesheet" href="css/reportFeatures-Boxed.css">
    <link rel="stylesheet" href="css/reportStyles.css">
    <script src="js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/Chart.js"></script>
</head>

<body>
    <div class="features-boxed">
        <div class="container">
            <div class="intro">
                <h2 class="text-center">Reports</h2>
            </div>
            <div class="row justify-content-center features">
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                	<canvas id="mycanvas1" width="300" height="300" style="margin-left:auto; margin-right:auto;"></canvas>               	
					<script>		
							var a = ${maleNum};
							var b = ${femaleNum};
							var ctx = document.getElementById("mycanvas1").getContext("2d")
							var data = {
								    datasets: [{
								    	backgroundColor: ['Red', 'Blue'],
								        data: [a, b],
								    	borderWidth:1,
								    }],
			
								    // These labels appear in the legend and in the tooltips when hovering different arcs
								    labels: [
								        'Male',
								        'Female'
								    ]
								};
							//draw
							var pieChart = new Chart(ctx, {
								type: 'pie', 
								data: data, 
								options: {
							        responsive:false,
							        maintainAspectRatio:false
						      	}});
					</script>
					<p>Male-Female ratio amongst members</p>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <canvas id="mycanvas2" width="300" height="300" style="margin-left:auto; margin-right:auto;"></canvas>               	
					<script>		
							var a = ${bookingsFacil1}
							var b = ${bookingsFacil2}
							var c = ${bookingsFacil3}
							var d = ${bookingsFacil4}
							var ctx = document.getElementById("mycanvas2").getContext("2d")
							var data = {
								    datasets: [{
								    	backgroundColor: ['Red', 'Blue', 'Yellow', 'Green'],
								        data: [a, b, c, d],
								    }],
			
								    // These labels appear in the legend and in the tooltips when hovering different arcs
								    labels: [
								       	'Pool',
								        'Court',
								        'Heaven',
								        'Hell'
								    ]
								};
							//draw
							var pieChart = new Chart(ctx, {
								type: 'bar', 
								data: data, 
								options: {
							        responsive:false,
							        maintainAspectRatio:false,
							        scales: {
							            yAxes: [{
							                ticks: {
							                    beginAtZero: true,
							                }
							            }]
							        }
						      	}});
					</script>
					<p>Number of bookings per facility</p>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <canvas id="mycanvas3" width="300" height="300" style="margin-left:auto; margin-right:auto;"></canvas>               	
					<script>		
							var a = ${actMainFacil1};
							var b = ${actMainFacil2};
							var c = ${actMainFacil3};
							var d = ${actMainFacil4};
							var ctx = document.getElementById("mycanvas3").getContext("2d")
							var data = {
								    datasets: [{
								    	backgroundColor: ['Red', 'Blue', 'Yellow', 'Green'],
								        data: [a, b, c, d],
								    	borderWidth:1,
								    }],
			
								    // These labels appear in the legend and in the tooltips when hovering different arcs
								    labels: [
								        'Pool',
								        'Court',
								        'Heaven',
								        'Hell'
								    ]
								};
							//draw
							var pieChart = new Chart(ctx, {
								type: 'doughnut', 
								data: data, 
								options: {
							        responsive:false,
							        maintainAspectRatio:false
						      	}});
					</script>
					<p>Number of facilities under active maintenance</p>
                </div>               
            </div>
            <div class="row justify-content-center features">
            	<div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box">
                        <h3 class="name">Members</h3>
                        <p class="description">Click below to generate a pdf of a member list showing all the members of the club and their contact details.</p>
	                   	<form:form method = "GET" action = "reports/report1">
					        <table style="display: flex; justify-content: center;">
					            <tr>
					               <td>
					                  <input type = "submit" value = "Member List" class="btn btn-outline-primary"/>
					               </td>
					            </tr>
					      	</table>  
						</form:form>
                	</div>
                </div>                
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box">
                        <h3 class="name">Facilities</h3>
                        <p class="description">Click below to generate a pdf of either a facility revenue report showing the amount of revenue generated per facility, or a facility usage report showing the amount of time a facility is used.</p>
                        <form:form method = "GET" action = "reports/report2">
					        <table style="display: flex; justify-content: center;">
					            <tr>
					               <td>
					                  <input type = "submit" value = "Facility Revenue Report" class="btn btn-outline-info"/>
					               </td>
					            </tr>
					      	</table>  
						</form:form>
						<form:form method = "GET" action = "reports/report3">
					        <table style="display: flex; justify-content: center;">
					            <tr>
					               <td>
					                  <input type = "submit" value = "Facility Usage Report" class="btn btn-outline-info"/>
					               </td>
					            </tr>
					      	</table>  
						</form:form>
                	</div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box">
                        <h3 class="name">Maintenance</h3>
                        <p class="description">Click below to generate a pdf showing the maintenance status on the facilites.</p>
                        <form:form method = "GET" action = "reports/report4">
					        <table style="display: flex; justify-content: center;">
					            <tr>
					               <td>
					                  <input type = "submit" value = "Maintenance Report" class="btn btn-outline-warning"/>
					               </td>
					            </tr>
					      	</table>  
						</form:form>
                  	</div>
               	</div>
            </div>
        </div>
    </div>    
</body>