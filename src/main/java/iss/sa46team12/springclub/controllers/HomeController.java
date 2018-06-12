package iss.sa46team12.springclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import iss.sa46team12.springclub.email.SendEmail;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		//testmail
		
		//SendEmail.sendEmail("springclub12@gmail.com", "to@gmail.com", "testing", "i'm just testing hal hal");
		return "home";
	}
	
}