package iss.sa46team12.springclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iss.sa46team12.springclub.models.BookingDetails;
//import iss.sa46team12.springclub.models.Facility;

public interface ReportRepository extends JpaRepository<BookingDetails, Integer> {

	@Query("SELECT Count(b) from BookingDetails b where facilityid = '1' ")
	int findNumOfBookingsFacil1();

	@Query("SELECT Count(b) from BookingDetails b where facilityid = '2' ")
	int findNumOfBookingsFacil2();

	@Query("SELECT Count(b) from BookingDetails b where facilityid = '3' ")
	int findNumOfBookingsFacil3();

	@Query("SELECT Count(b) from BookingDetails b where facilityid = '4' ")
	int findNumOfBookingsFacil4();
	
	@Query("SELECT Count(b) from BookingDetails b where facilityid = '5' ")
	int findNumOfBookingsFacil5();
}
