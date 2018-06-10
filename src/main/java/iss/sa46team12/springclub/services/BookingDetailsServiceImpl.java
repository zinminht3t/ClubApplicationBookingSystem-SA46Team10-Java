package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.models.BookingId;
import iss.sa46team12.springclub.repositories.BookingDetailsRepository;

public class BookingDetailsServiceImpl implements BookingDetailsService {
	
	@Resource
	BookingDetailsRepository bookingDetailsRepository;
	@Override
	@Transactional
	public ArrayList<BookingDetails> getAllBookings() {
		
		return ((ArrayList<BookingDetails>) bookingDetailsRepository.findAll());
	}

	@Override
	@Transactional
	public BookingDetails findBooking(BookingId bookingdetail) {
		
		return null;
	}

	@Override
	@Transactional
	public BookingDetails createBooking(BookingId bookingdetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public BookingDetails changeBooking(BookingId bookingdetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void removeBooking(BookingId bookingdetail) {
		// TODO Auto-generated method stub

	}

}
