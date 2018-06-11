
package iss.sa46team12.springclub.repositories;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	@Query("select b from BookingDetails b WHERE b.facilityid = :fid AND b.booking.status = 'CONFIRMED' AND date(b.bookingdate) = :bdate")
	ArrayList<BookingDetails> findAllConfirmedBookingsByCourtAndDate(@Param("fid") int fid, @Param("bdate") Date bdate);
	  
}
=======
package iss.sa46team12.springclub.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	//@Query("SELECT 	b from BookingDetails b WHERE b.status = 'CONFIRMED'")
	//ArrayList<BookingDetails> findAllConfirmedBookingsByCourtAndDate();
	//@Param("bdate") LocalDateTime bdate,
}
>>>>>>> branch 'master' of https://github.com/zinminht3t/SA46Team12CABProject.git
