package iss.sa46team12.springclub.controllers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.services.FacilityService; 

@RequestMapping(value="/facilities")
@Controller
public class FacilityController {

	@Autowired
	FacilityService facService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView facilitybooking(Model model) {
		ModelAndView mav = new ModelAndView("facilities");
		ArrayList<Facility> allfacilities = facService.findAllActiveFacility();
		mav.addObject("allfacility", allfacilities);

//		LocalDate localDate = LocalDate.now();
//		Calendar dateWithoutTimec = Calendar.getInstance();
//		dateWithoutTimec.setTime(Date.valueOf(localDate));
		SimpleDateFormat aaaa = new SimpleDateFormat("yyyy/MM/dd");
//		aaaa.format(dateWithoutTimec.getTime());
		Date currDate = new Date();
		String a = aaaa.format(currDate);
		a = a.replaceAll("/", "-");
		
		model.addAttribute("date", a);
		return mav;
	}

}
