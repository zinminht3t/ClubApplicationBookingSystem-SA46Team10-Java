package iss.sa46team12.springclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.models.Users;
import iss.sa46team12.springclub.services.LoginService;

//@RequestMapping(value = "/login")
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginsvc;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("login", "userLogin", new Users());
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		
		UserSession us = new UserSession();
		if (user.getEmail() != null && user.getPassword() != null) {
			User u = loginsvc.validateuser(user.getEmail(), user.getPassword());
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			mav = new ModelAndView("membership");
		}
		else {
			mav = new ModelAndView("login");
		}
		return mav;
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String home() {
//		return "login";
//	}

//	 @RequestMapping(value = "/login", method = RequestMethod.POST)
//	 public String handleloginrequest(@RequestParam String user, @RequestParam	 String password, ModelMap model) {
//		 User u = loginsvc.validateuser(user, password);
//		 if(u != null) {
//			 return "membership";
//		 }
//		 else {
//			 model.put("errormsg", "Invalid Credentials");
//			 return "login";
//		 }
//	 }
}




