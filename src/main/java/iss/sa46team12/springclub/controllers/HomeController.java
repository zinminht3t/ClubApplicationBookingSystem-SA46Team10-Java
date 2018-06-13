package iss.sa46team12.springclub.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import iss.sa46team12.springclub.email.SendEmail;
import iss.sa46team12.springclub.models.User;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		//testmail
		
		//SendEmail.sendEmail("springclub12@gmail.com", "to@gmail.com", "testing", "i'm just testing hal hal");
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String email(HttpServletRequest req) {
//		ModelAndView mav = new ModelAndView();
//		if(results.hasErrors())
//			return new ModelAndView("home");
		
		SendEmail.sendEmail(req.getParameter("em"), "springclub12@gmail.com",
				"Feedback: " + req.getParameter("sb"), "From: " + req.getParameter("nm") + " - " + req.getParameter("FB"));
//		mav.setViewName("/");
		return "home";
	}

}