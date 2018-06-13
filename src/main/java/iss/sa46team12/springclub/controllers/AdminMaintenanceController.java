package iss.sa46team12.springclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iss.sa46team12.springclub.models.Maintenance;
import iss.sa46team12.springclub.services.MaintenanceService;

@RequestMapping("/admin")
@Controller
public class AdminMaintenanceController {

	@Autowired
	MaintenanceService maintenanceService;

	// ********** Edit Maintenance ***************

	@RequestMapping(value = "/facility/MaintenanceFormEdit/{maintenanceID}", method = RequestMethod.GET)
	public ModelAndView logic(@PathVariable Integer maintenanceID, Model model) {
		ModelAndView mav = new ModelAndView("MaintenanceFormEdit", "maintenance", new Maintenance());
		mav.addObject("maintenance", maintenanceService.findMaintenance(maintenanceID));
		return mav;
	}

	@RequestMapping(value = "/facility/MaintenanceFormEdit/{maintenanceID}", method = RequestMethod.POST)
	public ModelAndView editMaintenance(@ModelAttribute Maintenance maintenance, @PathVariable Integer maintenanceID,
			final RedirectAttributes redirectAttributes) {
		
		Maintenance currMaintenance = maintenanceService.findMaintenance(maintenanceID);

		currMaintenance.setActive(false);
		
		maintenanceService.changeMaintenance(currMaintenance);

		ModelAndView mav = new ModelAndView("redirect:/admin/calendar/maintenance/list");
		String message = "Maintenance " + maintenance.getMaintenanceid() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
