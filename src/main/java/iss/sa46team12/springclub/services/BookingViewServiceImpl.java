package iss.sa46team12.springclub.services;

import java.time.LocalDateTime;
import java.util.ArrayList;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.models.BookingView;
import iss.sa46team12.springclub.repositories.BookingDetailsRepository;
import iss.sa46team12.springclub.repositories.BookingViewRepository;

@Service
public class BookingViewServiceImpl implements BookingViewService {

	@Resource
	BookingViewRepository bookingViewRepo;

	@Override
	public ArrayList<BookingView> findBookingMinMaxTimeslots() {
		// TODO Auto-generated method stub
		return (ArrayList<BookingView>) bookingViewRepo.findAll(); 
	}
	
	

}
