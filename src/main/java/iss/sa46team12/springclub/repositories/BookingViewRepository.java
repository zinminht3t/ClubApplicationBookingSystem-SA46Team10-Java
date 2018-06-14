package iss.sa46team12.springclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import iss.sa46team12.springclub.models.BookingView;

public interface BookingViewRepository extends JpaRepository<BookingView, Integer> {
	//
	// @Query("SELECT b from new_view b")
	// ArrayList<BookingView> findBookingMinMaxTimeslots();

}
