package iss.sa46team12.springclub.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.UserService; 

@RequestMapping("/admin/user")
@Controller
public class UserController {

	@Autowired
	UserService userService;
	 
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("UserList");
		ArrayList<User> userlist = userService.findAllUsers();		
		mav.addObject("userlist", userlist);
		return mav;
	}	

	@RequestMapping(value = "/edit/{nric}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable String nric) {
		ModelAndView mav = new ModelAndView("UserFormEdit");
		//mav.addObject("user", userService.findUserByNric(nric));
		return mav;
	}

	@RequestMapping(value = "/edit/{nric}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user, @PathVariable String nric,
			BindingResult result, final RedirectAttributes redirectAttributes) {		
		if (result.hasErrors())
			return new ModelAndView("UserFormEdit");
		userService.editUser(user);
		ModelAndView mav = new ModelAndView("redirect:/admin/user/edit");
		String message = "User" + user.getUserid() + " was successfully updated.";		
		return mav;
	}
	
}
