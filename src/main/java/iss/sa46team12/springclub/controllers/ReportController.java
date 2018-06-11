package iss.sa46team12.springclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	ReportService rService;
	
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String load() {		
		return "reports";
	}
	
//	@GetMapping("/reports")
//	public int getMaleNum() {
//		return rService.
//	}
	
	/*@RequestMapping(value = "/userprofile", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("UserProfile");
		User userProfile = rService.findUserById(1);		
		mav.addObject("userProfile", userProfile);
		return mav;
	}*/
}