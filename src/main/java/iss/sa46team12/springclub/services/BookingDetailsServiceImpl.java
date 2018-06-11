package iss.sa46team12.springclub.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.repositories.BookingDetailsRepository;

public class BookingDetailsServiceImpl implements BookingDetailsService {

	BookingDetailsRepository bookingDetails;
	@Override
	public ArrayList<BookingDetails> findAllConfirmedBookingsByCourtAndDate(LocalDateTime bdate, Integer fid) {
		
		return bookingDetails.findAllConfirmedBookingsByCourtAndDate(bdate, fid);
	}

}
