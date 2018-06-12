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
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <canvas id="mycanvas2" width="300" height="300" style="margin-left:auto; margin-right:auto;"></canvas>               	
					<script>		
							var a = ${maleNum};
							var b = ${femaleNum};
							var ctx = document.getElementById("mycanvas2").getContext("2d")
							var data = {
								    datasets: [{
								    	backgroundColor: ['Red', 'Blue'],
								        data: [a, b],
								    	borderWidth:1,
								    }],
			
								    // These labels appear in the legend and in the tooltips when hovering different arcs
								    labels: [
								        'Male',
								        'Females'
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
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <canvas id="mycanvas3" width="300" height="300" style="margin-left:auto; margin-right:auto;"></canvas>               	
					<script>		
							var a = ${maleNum};
							var b = ${femaleNum};
							var ctx = document.getElementById("mycanvas3").getContext("2d")
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
                </div>               
            </div>
            <div class="row justify-content-center features">
            	<div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-leaf icon"></i>
                        <h3 class="name">Organic </h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p>
                        <a href="#" class="learn-more">Learn more »</a>
                	</div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-plane icon"></i>
                        <h3 class="name">Fast </h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a href="#" class="learn-more">Learn more »</a></div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-phone icon"></i>
                        <h3 class="name">Mobile-first</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a href="#" class="learn-more">Learn more »</a></div>
                </div>
            </div>
        </div>
    </div>
    
</body>

</html>