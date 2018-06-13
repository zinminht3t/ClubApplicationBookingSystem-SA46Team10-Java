<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<%@ page session="false"%>
<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Spring Club</title>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="fonts/font-awesome.min.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/Team-Clean.css">
    <link rel="stylesheet" href="assets/css/Contact-Form-v2-Modal--Full-with-Google-Map.css">
    <script src="js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/Contact-Form-v2-Modal--Full-with-Google-Map.js"></script>  
</head>

<body>
	<!-- carousel -->
	<div class="container" width="80%" margin-right="10%" margin-left="10%" padding-top="120px" margin-top="120px" >
		<div id="carouselId" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselId" data-slide-to="0" class="active"></li>
				<li data-target="#carouselId" data-slide-to="1"></li>
				<li data-target="#carouselId" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox" width="100%">
				<div class="carousel-item active" styles="margin-left:auto; margin-right: auto;">
					<img src="image/vista.png" alt="First slide" width="100%"
						height="420px" styles="margin-left:auto; margin-right: auto;">
					<div class="carousel-caption d-none d-md-block">
					</div>
				</div>
				<div class="carousel-item" styles="margin-left:auto; margin-right: auto;">
					<img src="image/golfvista.png" alt="Second slide" width="100%"
						height="420px" styles="margin-left:auto; margin-right: auto;">
					<div class="carousel-caption d-none d-md-block">
					</div>
				</div>
				<div class="carousel-item" styles="margin-left:auto; margin-right: auto;">
					<img src="image/tennisvista.png" alt="Third slide" width="100%"
						height="420px" styles="margin-left:auto; margin-right: auto;">
					<div class="carousel-caption d-none d-md-block">
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselId" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselId" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	
	<br />
	<br />
	
	<!-- history and all that -->
	<div class="team-clean">
        <div class="container" style="background-color: #343A40;">
            <div class="intro">
                <h2 class="text-center" id="aboutus" style="color: white">ABOUT US </h2>
                <p class="text-center" style="color: white">Spring Club was founded in 1882 Sir Stampford Waffles in the prestigious Singamalam disctrict of sunny Singapore.</p>
            </div>
            <div class="row people">
                <div class="col-md-6 col-lg-4 item"><img src="image/historical.png">
                    <h3 class="name" style="color: white">Historical Holdings</h3>
                    <p class="description" style="color: white">Bask in the glory of ancient history and wander through the different relics and historical buildings scattered throughout the club's compound.</p>                   
                </div>
                <div class="col-md-6 col-lg-4 item"><img src="image/lodgings.png">
                    <h3 class="name" style="color: white">Luxurious Lodgings</h3>
                    <p class="description" style="color: white">Indulge yourself to a gorgeous weekend with a staycation in one of the many rooms the club has to offer. Or just enjoy the facilities provided to members.</p>
                    <div class="social"><a href="#"><i class="fa fa-facebook-official"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-instagram"></i></a></div>
                </div>
                <div class="col-md-6 col-lg-4 item"><img src="image/staff.png">
                    <h3 class="name" style="color: white">Serviceful Staff</h3>
                    <p class="description" style="color: white">Our highly trained and enthusiastic staff can't wait to pamper you and help you indulge in any of what the club has to offer you.</p>
                </div>
            </div>
        </div>
    </div>
	
	<br />
	<br />
	
	<!-- map and contactNew -->
	<div class="container" width="80%" margin-right="10%" margin-left="10%" padding-top="120px" margin-top="120px">
        <div class="container-fluid" id="contactus">
            <h1 class="text-center">Contact Information</h1>
            <hr>
            <form action="${pageContext.request.contextPath}/" class="contact-form" method="post">
            <input class="form-control" type="hidden" name="Introduction" value="This email was sent from springclub.com">
            <input class="form-control" type="hidden" name="subject" value="springclub.com Contact Form">
            <input class="form-control" type="hidden" name="to" value="springclub12@gmail.com">
                <div class="form-row">
                    <div class="col-md-6">
                        <div id="successfail"></div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-12 col-md-6" id="contact-us-form">
                    
                        <h2 class="h4"><i class="fa fa-envelope"></i> Contact Us<small><small class="required-input">&nbsp;(*required)</small></small></h2>
                        
                        <div class="form-group"><label for="from-name">Name</label><span class="required-input">*</span>
                            <div class="input-group">
                                <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-user-o"></i></span></div>
                                <input class="form-control" type="text" name="nm" required="required" placeholder="Full Name" id="name">
                            </div>
                        </div>
                        
                        <div class="form-group"><label for="from-email">Email</label><span class="required-input">*</span>
                            <div class="input-group">
                                <div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-envelope-o"></i></span></div>
                                <input class="form-control" type="text" name="em" required="required" placeholder="Email Address" id="email">
                            </div>
                        </div>
                        
                        <div class="form-group">
                        	<div class="form-group"><label for="from-phone">Subject</label><span class="required-input">*</span>
                        		<div class="input-group-prepend"><span class="input-group-text"><i class="fa fa-phone"></i></span></div>
                        		<input class="form-control" type="text" name="sb" required="required" placeholder="Subject" id="sb">
                        	</div>
                        </div>
                        
                        <div class="form-group"><label for="from-comments">Comments</label><textarea class="form-control textarea-contact" rows="5" name="FB" placeholder="Enter Comments" id="comment"></textarea></div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col"><button class="btn btn-primary btn-block" type="reset"><i class="fa fa-undo"></i> Reset</button></div>
                                <div class="col"><button class="btn btn-primary btn-block" type="submit">Submit <i class="fa fa-chevron-circle-right"></i></button></div>
                            </div>
                        </div>
                        <hr class="d-flex d-md-none">
                    </div>
                    
                    <div class="col-12 col-md-6">
                        <h2 class="h4 text-center"><i class="fa fa-location-arrow"></i> Locate Us</h2>
                        <div class="form-row">
                        
                        	<!-- google map! -->
                        	<div id="map"></div>
                            <div class="col-sm-6 col-md-12 col-lg-6 text-center">
                                <h2 class="h4"><i class="fa fa-user"></i> Our Info</h2>
                                <div><span><strong>Spring Club Staff</strong></span></div>
                                <div><span>springclub12@gmail.com</span></div>
                                <div><abbr data-toggle="tooltip" data-placement="top" title="Office Phone: +65-1234 5678">O:</abbr> +65-1234 5678</div>
                                <hr class="d-sm-none d-md-block d-lg-none">
                            </div>
                            <div class="col-sm-6 col-md-12 col-lg-6 text-center">
                                <h2 class="h4"><i class="fa fa-location-arrow"></i> Our Address</h2>
                                <div><span><strong>Spring Club</strong></span></div>
                                <div><span>25 Heng Mui Keng Terrace, </br>Singapore 119615</span></div>
                                <div><span>Mon - Sun: 9:00am - 9:00pm</span></div>      
                                <hr class="d-sm-none">
                            </div>
                            <!-- google map! -->
                            
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

	</br>
	</br>
	</br>
	</br>

	<script>
		function initMap() {
			// 25 Heng Mui Keng Terrace Longtidue / Latitude
			var myLatLng = {
				lat : 1.2921820,
				lng : 103.7766000
			};

			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 15,
				center : myLatLng
			});

			var marker = new google.maps.Marker({
				position : myLatLng,
				map : map,
			});
		}
	</script>


	<!-- <script src="js/jquery.slicknav.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script> -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
	<!--Google Map API Key-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCqotvyyArrgsFiiKdRZvGazSRywjI7cds&callback=initMap">
		
	</script>

</body>

</html>