package iss.sa46team12.springclub.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.repositories.BookingDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Resource
	BookingDetailsRepository bookingDetails;
	@Override
	@Transactional
	public ArrayList<BookingDetails> findAllConfirmedBookingsByCourtAndDate() {
		
		///return bookingDetails.findAllConfirmedBookingsByCourtAndDate();
		//LocalDateTime bdate, 
	}

}
