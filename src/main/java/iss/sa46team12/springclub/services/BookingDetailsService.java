
package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.BookingDetails;

public interface BookingDetailsService {

	public ArrayList<BookingDetails> findAllConfirmedBookingsByCourtAndDate();
	//LocalDateTime bdate, 
}
