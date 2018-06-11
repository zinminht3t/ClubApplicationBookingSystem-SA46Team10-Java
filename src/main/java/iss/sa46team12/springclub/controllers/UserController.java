package iss.sa46team12.springclub.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
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

@RequestMapping(value = "/user")
@Controller
public class UserController {



	@Autowired
	UserService uService;

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView editProfile() {
		ModelAndView mav = new ModelAndView("userprofile", "changeUserPassword", new User());
		User userProfile = uService.findUserById(1);
		mav.addObject("userProfile", userProfile);
		return mav;
	}

	@RequestMapping(value = "/profile/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav;
		if (result.hasErrors())
			return new ModelAndView("userprofile");

		mav = new ModelAndView("redirect:/user/profile");

		User up = uService.findUserById(1);
		up.setAddress(user.getAddress());
		up.setContactno(user.getContactno());
		up.setFullname(user.getFullname());
		up.setDateofbirth(user.getDateofbirth());
		up.setEmail(user.getEmail());
		up.setGender(user.getGender());
		up.setNric(user.getNric());

		String message = "User was successfully updated.";
		//uService.changeProfile(up);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}
