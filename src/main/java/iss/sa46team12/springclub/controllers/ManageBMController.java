package iss.sa46team12.springclub.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.Maintenance;
import iss.sa46team12.springclub.services.BookingsService;
import iss.sa46team12.springclub.services.FacilityService;
import iss.sa46team12.springclub.services.MaintenanceService; 

//controller class for admin to manage bookings and maintenances

@RequestMapping("/admin/bm")
@Controller
public class ManageBMController {

	@Autowired
	BookingsService bookingService;
	
	@Autowired
	MaintenanceService maintenanceService;
	 
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public ModelAndView listAllCfmBookings() {
		ModelAndView mav = new ModelAndView("adminCalendar");
		ArrayList<Bookings> bookingList = bookingService.findAllConfirmedBookings();		
		mav.addObject("bookingList", bookingList);
		return mav;
	}
	
	@RequestMapping(value = "/calendar2", method = RequestMethod.GET)
	public ModelAndView listAllCfmMaintenances() {
		ModelAndView mav = new ModelAndView("adminCalendar2");
		ArrayList<Maintenance> maintenanceList = maintenanceService.findAllActiveMaintenances();		
		mav.addObject("maintenanceList", maintenanceList);
		return mav;
	}
	
}
