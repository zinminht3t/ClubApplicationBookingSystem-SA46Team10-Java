package iss.sa46team12.springclub.controllers;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.UserService;


@RequestMapping(value="/user")
@Controller
public class UserController {

	@Autowired
	UserService uService;
	 
	@RequestMapping(value = "/userprofile", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("UserProfile");
		User userProfile = uService.findUserById(1);		
		mav.addObject("userProfile", userProfile);
		return mav;
	}
}
