
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <spring:url value="/css/Modal.css" var="selectTimeslotPopup" />
<link rel="STYLESHEET" type="text/css" href="${selectTimeslotPopup}" />
</head>
<body>

<div class="container">
  <h2>Select timeslot</h2>
  <a href="${pageContext.request.contextPath}/admin/calendar/maintenance/selectTimeslotPopup">List
	Facilities</a>
	<c:if test="${fn:length(timeslotsList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
			   <th>Timeslot Id</th>
			   <th>Timeslot Name</th>
			</tr>
		</thead>
		<tbody>
		
			
			<c:forEach var="timeslot" items="${timeslotsList}">
			
				<tr class="timeslotRecord">
					<td>${timeslot.getTimeslotid()}</td>
					<td>${timeslot.getTime()}</td>
				</tr>
					
			</c:forEach>
		</tbody>
	</table>
</c:if>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-default btn-lg" id="myBtn">OK</button>
  <button type="button" class="btn btn-default btn-lg" id="myBtn">CANCEL</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form">
           

            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Active</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>Not a member? <a href="#">Sign Up</a></p>
          <p>Forgot <a href="#">Password?</a></p>
        </div>
      </div>
      
    </div>
  </div> 
</div>
 
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>

</body>
</html>
