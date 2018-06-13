package iss.sa46team12.springclub.controllers;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.FacilityService; 

@RequestMapping(value="/facilities")
@Controller
public class FacilityController {

	@Autowired
	FacilityService facService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView facilitybooking() {
		ModelAndView mav = new ModelAndView("facilities");
		ArrayList<String> allfacilities = facService.findAllDistinctFacilityName();
		mav.addObject("allfacility", allfacilities);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postToBooking(Model model) {
		ModelAndView mav = new ModelAndView("confirm-booking");
		LocalDate localDate = LocalDate.now();
		Calendar dateWithoutTimec = Calendar.getInstance();
		dateWithoutTimec.setTime(Date.valueOf(localDate));
		SimpleDateFormat aaaa = new SimpleDateFormat("dd/MM/yyyy");
		aaaa.format(dateWithoutTimec.getTime());
		model.addAttribute("date", aaaa);
		return mav;
	}

}
