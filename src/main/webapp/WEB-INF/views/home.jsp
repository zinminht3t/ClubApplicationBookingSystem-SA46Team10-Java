<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<%@ page session="false"%>
<!doctype html>
<html lang="en">

<head>
<title>Spring Club</title>

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">  
</head>

<body>
	<div class="container" width="60%" margin-right="10%" margin-left="10%" padding-top="120px" margin-top="120px" >
		<div id="carouselId" class="carousel slide" data-ride="carousel"
			width="60%">
			<ol class="carousel-indicators">
				<li data-target="#carouselId" data-slide-to="0" class="active"></li>
				<li data-target="#carouselId" data-slide-to="1"></li>
				<li data-target="#carouselId" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox" width="60%">
				<div class="carousel-item active"
					styles="margin-left:auto; margin-right: auto;">
					<img src="Images/la.jpg" alt="First slide" width="100%"
						height="420px" styles="margin-left:auto; margin-right: auto;">
					<div class="carousel-caption d-none d-md-block">
						<button class="default" type="submit">Read More</button>
					</div>
				</div>
				<div class="carousel-item"
					styles="margin-left:auto; margin-right: auto;">
					<img src="Images/chicago.jpg" alt="Second slide" width="100%"
						height="420px" styles="margin-left:auto; margin-right: auto;">
					<div class="carousel-caption d-none d-md-block">
						<button class="default" type="submit">Read More</button>
					</div>
				</div>
				<div class="carousel-item"
					styles="margin-left:auto; margin-right: auto;">
					<img src="Images/ny.jpg" alt="Third slide" width="100%"
						height="420px" styles="margin-left:auto; margin-right: auto;">
					<div class="carousel-caption d-none d-md-block">
						<button class="default" type="submit">Read More</button>
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

	<div class="container">
		<div class="card">
			<div class="card-block text-center">
				<h2 id="aboutus">
					About Us
					</h2>
			</div>

		</div>
		<br />
		<div class="row">
			<div class="col-md-6 col-lg-3">
				<div class="card">
					<img src="Images/WhatsappImage.jpeg"
						class="card-img-top card-fluid" />
					<div class="card-block">
						<h3 class="card-title text-center">Our Story</h3>
						<p text-align="center">our facilities here</p>
					</div>

				</div>
			</div>
			<div class="col-md-6 col-lg-3">
				<div class="card">
					<img src="Images/WhatsappImage.jpeg"
						class="card-img-top card-fluid" />
					<div class="card-block">
						<h3 class="card-title text-center">Our Vision</h3>
						<p>our facilities here</p>
					</div>

				</div>
			</div>
			<div class="col-md-6 col-lg-3">
				<div class="card">
					<img src="Images/WhatsappImage.jpeg"
						class="card-img-top card-fluid" />
					<div class="card-block">
						<h3 class="card-title text-center">Our Mission</h3>
						<p>our facilities here</p>
					</div>

				</div>
			</div>
			<div class="col-md-6 col-lg-3">
				<div class="card">
					<img src="Images/WhatsappImage.jpeg"
						class="card-img-top card-fluid" />
					<div class="card-block">
						<h3 class="card-title text-center">Our Team</h3>
						<p>our facilities here</p>
					</div>

				</div>
			</div>
		</div>
		<br />
	</div>
	<div class="container">
		<div class="card">
			<div class="card-block text-center" id="contactus">
				<h2>
					Contact Us
					</h2>
			</div>

		</div>
		<br />
		<div class="card-group col-xs-4">
			<div class="card bg-light mb-3 text-center" style="max-width: 350px;">
				<div class="card-header">
					<h5>Location</h5>
				</div>
				<!-- Google Map -->
				<div id="map"></div>
				<div class="card-footer bg-light">
					<h6>Address</h6>
					<p>25 Heng Mui Keng Terrace, Singapore 119615</p>
					<h6>Opening Hours</h6>

					<p>Mon - Sun: 9:00am - 9:00pm
				</div>

			</div>
			<div class="card bg-light mb-3 text-center">
				<div class="card-header">
					<h5>Contact Us</h5>
				</div>
				<!-- Google Map -->
				<div id="contact-us-form">
				 <form action="${pageContext.request.contextPath}/" class="contact-form" method="post">
              
                          <div class="form-group">
                             <input type="text" class="form-control" id="name" name="nm" placeholder="Name" required="required" autofocus>

                          </div>
                      
                      
                          <div class="form-group form_left">
                             <input type="email" class="form-control" id="email" name="em" placeholder="Email" required="required"> 

                          </div>
                      
                        <div class="form-group">
                              <input type="text" class="form-control" id="sb" name="sb" placeholder="Subject" required="required"> 

                        </div>
                        <div class="form-group">
                         <textarea class="form-control textarea-contact" rows="5" id="comment" name="FB" placeholder="Type Your Message/Feedback here..." required="required"></textarea> 

                        <br>
                          <button class="btn btn-default btn-send"> <span class="glyphicon glyphicon-send"></span> Send </button>
                        </div>
                       </form>
					<!-- form validation here - do in jsp using tag library -->
<%-- 					<form:form modelAttribute="user" class="contact-form" method="POST"
						action="${pageContext.request.contextPath}/login/authenticate">
						<table class="framed">
							<tr>
								<td><spring:message code="Email / Username: " /></td>
								<td colspan="3"><form:input path="email" size="40"
										required="required" /></td>
							</tr>
							<tr>
								<td><spring:message code="Password: " /></td>
								<td colspan="3"><form:password path="password" size="40"
										required="required" /></td>
							</tr>
							<tr>
								<td colspan="4">&nbsp;
									<p class="label label-danger">${errormsg}</p>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><form:button class="btn btn-success" name="submit"
										type="submit" value="Login">

									</form:button></td>
								<td><form:button class="btn btn-danger" name="clear"
										type="reset" value="Reset">

									</form:button></td>
							</tr>
						</table>
					</form:form> --%>
					<!-- End Of Contact Us -->

				</div>
				<div class="card-footer bg-light">
					<h6>Email</h6>
					<p>springclub12@gmail.com</p>
					<h6>Tel No.</h6>
					<p>+65-1234 5678</p>


				</div>

			</div>

		</div>

	</div>






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