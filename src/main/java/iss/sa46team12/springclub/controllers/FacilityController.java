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

import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.services.FacilityService; 

@RequestMapping("/admin/facility")
@Controller
public class FacilityController {

	@Autowired
	FacilityService facService;
	 
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("FacilityList");
		ArrayList<Facility> facilitylist = facService.findAllFacilities();		
		mav.addObject("facilitylist", facilitylist);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newFacilityPage() {
		ModelAndView mav = new ModelAndView("FacilityFormNew", "facility", new Facility());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("FacilityFormNew");
		ModelAndView mav = new ModelAndView();
		
		facService.createFacility(facility);
		String message = "New facility " + facility.getFacilityID() + " was successfully created.";
		mav.setViewName("redirect:/admin/facility/list");
		return mav;
	}


	@RequestMapping(value = "/edit/{name}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable String name) {
		ModelAndView mav = new ModelAndView("FacilityFormEdit");
		mav.addObject("facility", facService.findFacilityByName(name));
		return mav;
	}

	@RequestMapping(value = "/edit/{name}", method = RequestMethod.POST)
	public ModelAndView editFacility(@ModelAttribute @Valid Facility facility, @PathVariable String name,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		System.out.println("facility"+facility.toString());
		if (result.hasErrors())
			return new ModelAndView("StudentFormEdit");
		facService.editFacility(facility);
		ModelAndView mav = new ModelAndView("redirect:/admin/facility/edit");
		String message = "Facility" + facility.getFacilityID() + " was successfully updated.";		
		return mav;
	}
	
}
