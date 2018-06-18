
package iss.sa46team12.springclub.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.Timeslots;
import iss.sa46team12.springclub.services.BookingDetailsService;
import iss.sa46team12.springclub.services.FacilityService;
import iss.sa46team12.springclub.services.TimeslotService;

@RequestMapping("/facilities")
@Controller
public class FacilityBookingController {

	@Autowired
	BookingDetailsService bookingDetailsService;

	@Autowired
	TimeslotService allTimeslots;

	@Autowired
	FacilityService courtsinFacility;

	@RequestMapping(value = "/confirm-booking/{datepicker}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView listAll(HttpSession session, @PathVariable("datepicker") String datepicker) {
		ModelAndView mav = new ModelAndView("confirm-booking");
		
		//Formatting datetime
		String str = datepicker + " 00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

		String fn = (String) session.getAttribute("fn");
		fn = fn.replaceAll("%20", "");
		session.setAttribute("fn", fn);

		// Get all the timeslots
		ArrayList<Timeslots> timeslots = allTimeslots.getAllTimeslots();
		// Get a list of all the courts under the category that is passed as an argument
		ArrayList<Facility> courts = courtsinFacility.getAllCourtsInFacility(fn);

		// A hashMap for mapping courts with their booking details
		LinkedHashMap<String, ArrayList<BookingDetails>> bookedCourtsTime = new LinkedHashMap<String, ArrayList<BookingDetails>>();
		
		for (Facility court : courts) {

			//Get a list of all booking details which matches the booking id and the date
			ArrayList<BookingDetails> bookingDetailsList = bookingDetailsService
					.findAllConfirmedBookingsByCourtAndDate(court.getFacilityID(), dateTime);
			bookedCourtsTime.put(court.getCourt(), bookingDetailsList);

		}
		
		// A hashMap of all courts and their available time
		LinkedHashMap<String, ArrayList<Timeslots>> availableCourtsTime = new LinkedHashMap<String, ArrayList<Timeslots>>();
		for (Map.Entry<String, ArrayList<BookingDetails>> courtBooking : bookedCourtsTime.entrySet()) {
			// For each court
			ArrayList<BookingDetails> bookingdetails = courtBooking.getValue();
			ArrayList<Timeslots> tempTimeslots = new ArrayList<Timeslots>(timeslots);
			for (BookingDetails bookingdetail : bookingdetails) {

				for (int i = 0; i < tempTimeslots.size(); i++) {
					// Removes all booked time from the list of available timeslots
					if (tempTimeslots.get(i).getTime().compareTo(bookingdetail.getTimeslots().getTime()) == 0)
						tempTimeslots.remove(i);
				}

			}
		
			availableCourtsTime.put(courtBooking.getKey(), tempTimeslots);
		}

		mav.addObject("availableCourtsTime", availableCourtsTime);
		mav.addObject("date", datepicker);
		mav.addObject("facilityname", fn);

		return mav;
	}
}