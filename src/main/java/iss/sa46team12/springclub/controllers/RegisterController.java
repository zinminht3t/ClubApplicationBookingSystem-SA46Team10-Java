package iss.sa46team12.springclub.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.UserService;
import iss.sa46team12.springclub.validators.UserValidator;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private UserValidator uValidator;
	
	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}
	

	@RequestMapping(value = "/register/{selectedPackage}", method = RequestMethod.GET)
	public ModelAndView logic(@PathVariable String selectedPackage, Model model) {
		
		ModelAndView mav = new ModelAndView("register", "user", new User());
		model.addAttribute("packageSelected", selectedPackage);
		return mav;
	}
	
			
	@RequestMapping(value = "/register/{selectedPackage}", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User users, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpServletRequest request, 
	        HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors())
			return new ModelAndView("register");

		
		String message = "New user " + users.getUserId() + " was successfully created.";
		
		users.setGender("Male");
		
		String dayOfBirth = request.getParameter("dayOfBirth");
		String monthOfBirth = request.getParameter("monthOfBirth");
		String yearOfBirth = request.getParameter("yearOfBirth");
		
		int day = Integer.parseInt(dayOfBirth);
		int month = Integer.parseInt(monthOfBirth);		
		int year = Integer.parseInt(yearOfBirth);
		
        Calendar cal = new GregorianCalendar(year, month-1, day);
        Date date = cal.getTime();   
        
//        Date date = new Date();
		users.setDateofbirth(date);
		
		users.setRole("Member");
		users.setActive(true);
		
		uService.createUser(users);
		mav.setViewName("redirect:/");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	


}