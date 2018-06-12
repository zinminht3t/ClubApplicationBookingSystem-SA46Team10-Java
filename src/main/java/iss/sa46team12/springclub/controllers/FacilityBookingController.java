package iss.sa46team12.springclub.controllers;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.services.BookingDetailsService;

@RequestMapping("/facilities")
@Controller
public class FacilityBookingController {

	@Autowired
	BookingDetailsService bookingDetailsService;
	
	@RequestMapping(value = "/confirm-booking", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("confirm-booking");
		String str = "2018-06-14 00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		ArrayList<BookingDetails> bookingDetailsList = bookingDetailsService.findAllConfirmedBookingsByCourtAndDate(1 , dateTime);
		mav.addObject("bookingDetailsList", bookingDetailsList);
		
		return mav;
	}
}
