<?php
if($_SERVER['REQUEST_METHOD']=='POST'){

include 'DatabaseConfig.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

 $selectedDate= $_POST['selectedDate'];
 $selectedUserid= $_POST['selectedUserid'];
 $selectedTotal= $_POST['selectedTotal'];
 $selectedStatus= $_POST['selectedStatus'];

$Sql_Query = "INSERT INTO bookings (transactiontime,userid,total,status) values ('$selectedDate', '$selectedUserid', '$selectedTotal', '$selectedStatus')";

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