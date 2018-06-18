
package iss.sa46team12.springclub.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.email.SendEmail;
import iss.sa46team12.springclub.models.BookingDetailsForBookingProcess;
import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.BookingDetailsForBookingProcessRepositoryService;
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
	public ModelAndView listAll(HttpServletRequest request, HttpSession session) {

		ModelAndView mav = new ModelAndView("booking-details");
		String facilitycategory = (String) session.getAttribute("fn");
		facilitycategory = facilitycategory.replaceAll("%20", "");
		ArrayList<Facility> courts = new ArrayList<Facility>(courtsinFacility.getAllCourtsInFacility(facilitycategory));
		double bookingPrice = 0;

		// A HashMap for storing all the courts in a facility as key and their available
		// times as value in list
		LinkedHashMap<Facility, ArrayList<String>> courtAndTimes = new LinkedHashMap<Facility, ArrayList<String>>();
		for (Facility court : courts) {
			ArrayList<String> eachCourt = new ArrayList<String>();

			String[] key = request.getParameterValues(court.getCourt()); // Getting all values for a given key from
																			// HttpServletRequest
			if (key != null) {
				for (String value : key) {
					eachCourt.add(value);
					bookingPrice = bookingPrice + court.getPrice(); // Calculating total booking price for each
																	// timeslots booked
				}
				courtAndTimes.put(court, eachCourt);
			}

		}

		User user = userService.findUserById((int) session.getAttribute("UserID"));
		LocalDateTime date = LocalDateTime.now();
		Bookings booking = createNewBooking(date, user, bookingPrice);

		String bookingdate = request.getParameter("selecteddate") + " 00:00";
		for (Map.Entry<Facility, ArrayList<String>> court : courtAndTimes.entrySet()) {

			// Each Key in LinkedHashMap
			for (String times : court.getValue()) {

				// for each timeslot in List of available times
				createNewBookingDetails(booking.getBookingid(), bookingdate, court.getKey().getPrice(),
						court.getKey().getFacilityID(), timeslotService.getOneTimeSlot(times).getTimeslotid());

			}

		}
		
		//Send a confirmation email after successfully placing a booking
		SendEmail.sendEmail("spring12@gmail.com", user.getEmail(), "Spring Club - Booking Confirmation",
				"Your booking has been placed successfully. Thank you!");
		
		mav.addObject("testSession", facilitycategory);
		mav.addObject("booking", booking);
		return mav;

	}

	// Method to create new Booking
	public Bookings createNewBooking(LocalDateTime date, User user, double bookingPrice) {

		Bookings booking = new Bookings();
		booking.setTransactiontime(date);
		booking.setUser(user);
		booking.setTotal((int) bookingPrice);
		booking.setStatus("CONFIRMED");
		bookingsService.createBooking(booking);

		return booking;
	}

	// Method to create new booking detail
	public void createNewBookingDetails(int bookingid, String bookingdate, double facilityprice, int facilityid,
			int timeslotid) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime convertedbookingdate = LocalDateTime.parse(bookingdate, formatter);

		BookingDetailsForBookingProcess bookingdetails = new BookingDetailsForBookingProcess();
		bookingdetails.setBookingid(bookingid);
		bookingdetails.setBookingdate(convertedbookingdate);
		bookingdetails.setBookingprice(facilityprice);
		bookingdetails.setFacilityid(facilityid);
		bookingdetails.setTimeslotid(timeslotid);
		bookingDetailsService.createBooking(bookingdetails);
	}

}
