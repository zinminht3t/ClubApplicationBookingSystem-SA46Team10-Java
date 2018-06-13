package iss.sa46team12.springclub.repositories;


import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.BookingView;

public interface BookingViewRepository extends JpaRepository<BookingView, Integer> {
//
//	@Query("SELECT b from new_view b")
//	ArrayList<BookingView> findBookingMinMaxTimeslots();
	  
}
