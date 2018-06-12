package iss.sa46team12.springclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.UserService;

@RequestMapping(value = "/login")
@Controller
public class LoginController {

	@Autowired
	UserService usersvc;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors() || user == null) {
			// add error msg
			return mav;
		}
		
		UserSession us = new UserSession();
		User u = usersvc.authenticate(user.getEmail(), user.getPassword());
			if (u.getNric() != null) {
				
				us.setUser(u);
				// PUT CODE FOR SETTING SESSION ID
				us.setSessionId(session.getId());
				
				if(u.getRole().equals("admin") && u.isActive() == (true)) {
					session.setAttribute("Role", "admin");
					session.setAttribute("UserID", u.getUserId());
					mav = new ModelAndView("redirect:/admin");
				}
				else 
				if(u.getRole().equals("member") && u.isActive() == true){
					session.setAttribute("Role", "member");
					session.setAttribute("UserID", u.getUserId());
					mav = new ModelAndView("redirect:/facilities");
				}
				else {
					mav = new ModelAndView("login","errormsg", "Your Account Has Expired. Please Register Again.");
				}
			}
			else {
				// add error msg
				mav = new ModelAndView("login", "errormsg", "Wrong Username / Password!");
			}

		return mav;
//		ModelAndView mav = new ModelAndView("login");
//		if(result.hasErrors()) {
//			return mav;
//		}
		
//		UserSession us = new UserSession();
//		String email = user.getEmail();
//		String password = user.getPassword();
//		System.out.println(email + " " + password);
//		User u = usersvc.authenticate(user.getEmail(), user.getPassword());
//		System.out.println(u.toString());
//		
//		return mav;
	}
	//
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String home() {
	// return "login";
	// }
	//
	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public String handleloginrequest(@RequestParam String user, @RequestParam
	// String password, ModelMap model) {
	// User u = loginsvc.validateuser(user, password);
	// if(u != null) {
	// return "membership";
	// }
	// else {
	// model.put("errormsg", "Invalid Credentials");
	// return "login";
	// }
	// }

}
