package iss.sa46team12.springclub.controllers;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	public ModelAndView listAll() throws ParseException {
		ModelAndView mav = new ModelAndView("confirm-booking");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		ArrayList<BookingDetails> bookingDetailsList = bookingDetailsService.findAllConfirmedBookingsByCourtAndDate(1, sdf.parse(sdf.format(new Date(2018-06-13))));
		mav.addObject("bookingDetailsList", bookingDetailsList);
		return mav;
	}
}
