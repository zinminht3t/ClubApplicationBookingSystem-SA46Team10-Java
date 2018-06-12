package iss.sa46team12.springclub.controllers;


import java.util.ArrayList;

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
		ArrayList<Facility> allfacilities = facService.findAllFacilities();
		mav.addObject("allfacility", allfacilities);
		return mav;
	}

}
