<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
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
                	<canvas id="mycanvas" width="300" height="300" style="margin-left:auto; margin-right:auto;"></canvas>               	
					<script>
							var ctx = document.getElementById("mycanvas").getContext("2d")
							var data = {
								    datasets: [{
								    	backgroundColor: ['Red', 'Yellow', 'Blue'],
								        data: [10, 20, 30],
								    	borderWidth:1,
								    }],
			
								    // These labels appear in the legend and in the tooltips when hovering different arcs
								    labels: [
								        'Red',
								        'Yellow',
								        'Blue'
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
                    <div class="box"><i class="fa fa-clock-o icon"></i>
                        <h3 class="name">Always available</h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a href="#" class="learn-more">Learn more »</a></div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-list-alt icon"></i>
                        <h3 class="name">Customizable </h3>
                        <p class="description">Hell on earth be realised. Nothing sacred is left untarnished. Nothing innocent left unravaged.</p><a href="#" class="learn-more">Learn more »</a></div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box"><i class="fa fa-leaf icon"></i>
                        <h3 class="name">Organic </h3>
                        <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu.</p><a href="#" class="learn-more">Learn more »</a></div>
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