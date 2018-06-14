package iss.sa46team12.springclub.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.models.BookingDetailsForBookingProcess;
import iss.sa46team12.springclub.models.BookingId;
import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.BookingDetailsForBookingProcessRepositoryService;
import iss.sa46team12.springclub.services.BookingDetailsService;
import iss.sa46team12.springclub.services.BookingsService;
import iss.sa46team12.springclub.services.FacilityService;
import iss.sa46team12.springclub.services.TimeslotService;
import iss.sa46team12.springclub.services.UserService;

@RequestMapping("/facilities/confirm-booking")
@Controller
public class BookingDetailsController {

	@Autowired
	BookingDetailsForBookingProcessRepositoryService bookingDetailsService;

	@Autowired
	FacilityService courtsinFacility;

	@Autowired
	BookingsService bookingsService;

	@Autowired
	UserService userService;

	@Autowired
	TimeslotService timeslotService;

	@RequestMapping(value = "/booking-details", method = RequestMethod.POST)
	public ModelAndView listAll(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("booking-details");

		ArrayList<Facility> courts = new ArrayList<Facility>(courtsinFacility.getAllCourtsInFacility("Tennis Court"));
		LinkedHashMap<Facility, ArrayList<String>> courtAndTimes = new LinkedHashMap<Facility, ArrayList<String>>();
		int bookingPrice = 0; 
		
		for (Facility court : courts) {
			ArrayList<String> eachCourt = new ArrayList<String>();
			String[] key;
			try {
				key = request.getParameterValues(court.getCourt());
			} catch (NullPointerException e) {
				key = null;
			}
			if (key != null) {
				for (String value : key) {
					eachCourt.add(value);
					bookingPrice = (int) (bookingPrice+court.getPrice());
				}
				courtAndTimes.put(court, eachCourt);
				
			}
		}

		User user = userService.findUserById(1);
		LocalDateTime date = LocalDateTime.now();
		Bookings booking = new Bookings();
		booking.setTransactiontime(date);
		booking.setUser(user);
		booking.setTotal(bookingPrice);
		booking.setStatus("CONFIRMED");
		bookingsService.createBooking(booking);

		String bookingdate = request.getParameter("selecteddate") + " 00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime convertedbookingdate = LocalDateTime.parse(bookingdate, formatter);
		

		// Each Map in Hash
		for (Map.Entry<Facility, ArrayList<String>> court : courtAndTimes.entrySet()) {
			// Each List in Map
			for (String times : court.getValue()) {
				// for each timeslot in List
				BookingDetailsForBookingProcess bookingdetails = new BookingDetailsForBookingProcess();
				
				bookingdetails.setBookingid(booking.getBookingid());
				bookingdetails.setBookingdate(convertedbookingdate);
				bookingdetails.setBookingprice(court.getKey().getPrice());
				bookingdetails.setFacilityid(court.getKey().getFacilityID());
				bookingdetails.setTimeslotid(timeslotService.getOneTimeSlot(times).getTimeslotid());
				
				bookingDetailsService.createBooking(bookingdetails);
			
			}

		}

		// mav.addObject("selecteddate", selecteddate);
		mav.addObject("courtAndTimes", courtAndTimes);
		mav.addObject("date", date);
		mav.addObject("request", request);
		return mav;
	}

}
