<?php
if($_SERVER['REQUEST_METHOD']=='POST'){

include 'DatabaseConfig.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

 $selectedBookingid= $_POST['selectedBookingid'];
 $selectedFacilityid= $_POST['selectedFacilityid'];
 $selectedTimeslotid= $_POST['selectedTimeslotid'];
 $selectedBookingDate= $_POST['selectedBookingDate'];
 $selectedBookingPrice= $_POST['selectedBookingPrice'];

$Sql_Query = "INSERT INTO bookingdetails (bookingid, facilityid, timeslotid, bookingdate, bookingprice) values ('$selectedBookingid', '$selectedFacilityid', '$selectedTimeslotid', '$selectedBookingDate', '$selectedBookingPrice')";

 if(mysqli_query($con,$Sql_Query))
{
 echo 'Booking Added Successfully';
}
else
{
 echo 'Something went wrong';
 }
 }
 mysqli_close($con);
?>