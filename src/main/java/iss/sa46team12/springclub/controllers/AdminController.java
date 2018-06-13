package iss.sa46team12.springclub.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa46team12.springclub.exceptions.FacilityNotFound;
import iss.sa46team12.springclub.exceptions.UserNotFound;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.FacilityService;
import iss.sa46team12.springclub.services.UserService;
import iss.sa46team12.springclub.validators.FacilityValidator;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	FacilityService facService;

	// ********** List Users ***************

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ModelAndView listAllUser() {
		ModelAndView mav = new ModelAndView("UserList");
		ArrayList<User> userlist = userService.findAllUsers();
		mav.addObject("userlist", userlist);
		return mav;
	}	
	
	// ********** Edit Users ***************

		@RequestMapping(value = "/user/UserFormEdit/{userId}", method = RequestMethod.GET)
		public ModelAndView editUserPage(@PathVariable Integer userId, Model model) {
			ModelAndView mav = new ModelAndView("UserFormEdit");
			 mav.addObject("users", userService.findUserById(userId));
			return mav;
		}

		@RequestMapping(value = "/user/edit/{userId}", method = RequestMethod.POST)
			public ModelAndView editUser(@ModelAttribute @Valid User users, @PathVariable Integer userId, BindingResult result,
					final RedirectAttributes redirectAttributes) throws UserNotFound{
				
				if (result.hasErrors())
					return new ModelAndView("UserFormEdit");
				userService.editUser(users);
				ModelAndView mav = new ModelAndView("redirect:/admin/user/list");	
				String message = "User " + users.getUserId() + " was successfully updated.";
				redirectAttributes.addFlashAttribute("message", message);
				return mav;			
			}
	
	
	// ********** List Facilities ***************

	@RequestMapping(value = "/facility/list", method = RequestMethod.GET)
	public ModelAndView listAllFacility() {
		ModelAndView mav = new ModelAndView("FacilityList");
		ArrayList<Facility> facilitylist = facService.findAllFacilities();
		mav.addObject("facilitylist", facilitylist);
		return mav;
	}

	// ********** Create Facility ***************

	@RequestMapping(value = "/facility/FacilityFormNew", method = RequestMethod.GET)
	public ModelAndView logic(Model model) {

		ModelAndView mav = new ModelAndView("FacilityFormNew", "facility", new Facility());
		return mav;
	}
	
	@RequestMapping(value = "/facility/create", method = RequestMethod.POST)
	public ModelAndView createFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
//		new FacilityValidator().validate(facility,result);

		if (result.hasErrors())
			return new ModelAndView("FacilityFormNew");

		ModelAndView mav = new ModelAndView();
		String message = "New facility " + facility.getFacilityID() + " was successfully created.";

		// Temporary PlaceHolder
		facility.setActive(true);

		facService.createFacility(facility);
		mav.setViewName("redirect:/admin/facility/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	// ********** Edit Facility ***************

	@RequestMapping(value = "/facility/FacilityFormEdit/{facilityID}", method = RequestMethod.GET)
	public ModelAndView logic(@PathVariable Integer facilityID, Model model) {
		ModelAndView mav = new ModelAndView("FacilityFormEdit", "facility", new Facility());
		 mav.addObject("facility", facService.findFacilityById(facilityID));
		return mav;
	}

	@RequestMapping(value = "/facility/edit/{facilityID}", method = RequestMethod.POST)
		public ModelAndView editFacility(@ModelAttribute @Valid Facility facility, @PathVariable Integer facilityID, BindingResult result,
				final RedirectAttributes redirectAttributes) throws FacilityNotFound{
			
			if (result.hasErrors())
				return new ModelAndView("FacilityFormEdit");
			facService.editFacility(facility);
			ModelAndView mav = new ModelAndView("redirect:/admin/facility/list");	
			String message = "Facility " + facility.getFacilityID() + " was successfully updated.";
			redirectAttributes.addFlashAttribute("message", message);
			return mav;			
		}
}

