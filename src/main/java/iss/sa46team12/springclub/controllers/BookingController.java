package iss.sa46team12.springclub.controllers;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.services.BookingsService;

@Controller
public class BookingController {

	@Autowired
	BookingsService bookingsService;
	
	@RequestMapping(value="/facilities/confirmbooking",method = RequestMethod.GET)
	public List<Bookings>  getAllBookings(){
		ArrayList<Bookings> allbookings = new ArrayList<Bookings>();
		allbookings = bookingsService.findAllConfirmedBookings();
		out.println(allbookings);
		return allbookings;
	}
}
