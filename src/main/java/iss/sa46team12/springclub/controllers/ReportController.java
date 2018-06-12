package iss.sa46team12.springclub.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	ReportService rService;
	
	//@RequestMapping(value = "/reports", method = RequestMethod.GET)
	//public String load() {		
	//	return "reports";
	//}
	
	/*@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public int maleNum() {
		int a = rService.findNumOfMales();
		return a;
	}*/
	
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public ModelAndView findMaleNumControl() {
		ModelAndView mav = new ModelAndView("reports");
		List<Integer> list = new ArrayList<Integer>();
		//list.add(rService.findNumOfMales());
		//list.add(rService.findNumOfFemales());
		int a = rService.findNumOfMales();
		int b = rService.findNumOfFemales();
		mav.addObject("maleNum", a);
		mav.addObject("femaleNum", b);
		return mav;
	}
	
	/*@RequestMapping(value = "/userprofile", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("UserProfile");
		User userProfile = rService.findUserById(1);		
		mav.addObject("userProfile", userProfile);
		return mav;
	}*/

}