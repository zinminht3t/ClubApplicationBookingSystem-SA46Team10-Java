package iss.sa46team12.springclub.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa46team12.springclub.models.Password;
import iss.sa46team12.springclub.models.Subscription;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.SubscriptionService;
import iss.sa46team12.springclub.services.UserService;
import iss.sa46team12.springclub.validators.UserValidator;

@RequestMapping(value = "/user")
@Controller
public class UserController {

	@Autowired
	UserService uService;
	@Autowired
	SubscriptionService sService;
	@Autowired
	private UserValidator uValidator;

	@InitBinder("userProfile")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView editProfile() {
		ModelAndView mav = new ModelAndView("profile", "changeUserPassword", new Password());
		User userProfile = uService.findUserById(1);
		Subscription sub = sService.findActiveSubscription(1);
		mav.addObject("userProfile", userProfile);
		mav.addObject("subscription", sub);
		return mav;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("profile");

		ModelAndView mav;
		mav = new ModelAndView("redirect:/user/profile");
		User up = uService.findUserById(1);
		up.setAddress(user.getAddress());
		up.setContactno(user.getContactno());
		up.setFullname(user.getFullname());
		up.setDateofbirth(user.getDateofbirth());
		up.setEmail(user.getEmail());
		up.setGender(user.getGender());
		up.setNric(user.getNric());
		uService.editUser(up);


		redirectAttributes.addFlashAttribute("showNotification", "Success");
		return mav;
	}

	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public ModelAndView changePassword(@ModelAttribute @Valid Password password, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("profile");

		ModelAndView mav;
		mav = new ModelAndView("redirect:/user/profile");


		//redirectAttributes.addFlashAttribute("showNotification", "Success");
		return mav;
	}
}
