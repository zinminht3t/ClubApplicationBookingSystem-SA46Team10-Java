package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.models.BookingId;

public interface BookingDetailsService {
	
	ArrayList<BookingDetails> getAllBookings();
	
	BookingDetails findBooking(BookingId bookingdetail);
	
	BookingDetails createBooking(BookingId bookingdetail);

	BookingDetails changeBooking(BookingId bookingdetail);

	void removeBooking(BookingId bookingdetail);
}
