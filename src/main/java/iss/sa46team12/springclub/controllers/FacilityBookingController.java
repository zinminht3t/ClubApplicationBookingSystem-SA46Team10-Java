package iss.sa46team12.springclub.controllers;

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
		ArrayList<BookingDetails> bookingDetailsList = bookingDetailsService.findAllConfirmedBookingsByCourtAndDate(1);
		mav.addObject("bookingDetailsList", bookingDetailsList);
		return mav;
	}
}
