package iss.sa46team12.springclub.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {
	@Query("select b from BookingDetails b WHERE b.facilityid = :fid AND b.booking.status = 'CONFIRMED' AND b.bookingdate = :bdate")
<<<<<<< HEAD
	ArrayList<BookingDetails> findAllConfirmedBookingsByCourtAndDate(@Param("fid") int fid,
			@Param("bdate") LocalDateTime bdate);

	@Query(value = "INSERT INTO bookingdetails values(?1, ?2, ?3, ?4, ?5)" , nativeQuery = true)
	int createBookingDetail(int bid, int fid, int tid, LocalDateTime bdate, double price);

=======
	ArrayList<BookingDetails> findAllConfirmedBookingsByCourtAndDate(@Param("fid") int fid, @Param("bdate") LocalDateTime bdate);
	
//	@Query("SELECT b FROM BookingDetails b WHERE b.facilityid =:fid")
//	BookingDetails bookingD(@Param("fid") int fid);
>>>>>>> aae6780ba740af52ff444667825e2f953f835cdf
}
