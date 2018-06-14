
package iss.sa46team12.springclub.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import iss.sa46team12.springclub.models.BookingDetails;

public interface BookingDetailsService {

	ArrayList<BookingDetails> findAllConfirmedBookingsByCourtAndDate(int fid, LocalDateTime bdate);

	int createBooking(BookingDetails booking);

}
