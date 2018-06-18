package iss.sa46team12.springclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(method = RequestMethod.POST)
	public String authenticate(@ModelAttribute User user, HttpSession session, BindingResult result, Model model) {

		UserSession us = new UserSession();
		User u = usersvc.authenticate(user.getEmail(), user.getPassword());
		if (u != null) {
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());

			if (u.getRole().equals("admin") && u.isActive() == true) {
				session.setAttribute("Role", "admin");
				session.setAttribute("UserID", u.getUserId());
				return "redirect:/reports";
			} else if (u.getRole().equals("member") && u.isActive() == true) {
				session.setAttribute("Role", "member");
				session.setAttribute("UserID", u.getUserId());
				return "redirect:/facilities";
			} else {
				model.addAttribute("errormsg", "Your Account Has Expired");
				return "login";
			}
		} else {
			model.addAttribute("errormsg", "Wrong Username / Password");
			return "login";
			
		}
	}

}