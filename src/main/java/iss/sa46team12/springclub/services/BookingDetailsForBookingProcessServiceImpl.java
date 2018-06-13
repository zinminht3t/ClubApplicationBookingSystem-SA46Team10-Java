package iss.sa46team12.springclub.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.BookingDetailsForBookingProcess;
import iss.sa46team12.springclub.repositories.BookingDetailsForBookingProcessRepository;

@Service
public class BookingDetailsForBookingProcessServiceImpl implements BookingDetailsForBookingProcessRepositoryService {

	@Resource
	BookingDetailsForBookingProcessRepository bookingDetails;
	
	@Override
	@Transactional
	public void createBooking(BookingDetailsForBookingProcess booking) {
		
		bookingDetails.saveAndFlush(booking);

	}

}
