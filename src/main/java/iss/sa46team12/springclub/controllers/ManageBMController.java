
package iss.sa46team12.springclub.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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

import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.Maintenance;
import iss.sa46team12.springclub.models.Timeslots;
import iss.sa46team12.springclub.services.BookingsService;
import iss.sa46team12.springclub.services.FacilityService;
import iss.sa46team12.springclub.services.MaintenanceService;
import iss.sa46team12.springclub.services.TimeslotService; 

//controller class for admin to manage bookings and maintenances

@RequestMapping("/admin")
@Controller
public class ManageBMController {

	@Autowired
	BookingsService bookingService;
	
	@Autowired
	MaintenanceService maintenanceService;
	
	@Autowired
	FacilityService facilityService;
	
	@Autowired
	TimeslotService timeslotService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	 
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public ModelAndView listAllCfmBookings() {
		ModelAndView mav = new ModelAndView("adminCalendar");
		ArrayList<Bookings> bookingList = bookingService.findAllConfirmedBookings();		
		mav.addObject("bookingList", bookingList);
		return mav;
	}
	
	@RequestMapping(value = "/calendar/maintenance/list", method = RequestMethod.GET)
	public ModelAndView flistAll() {
		ModelAndView mav = new ModelAndView("MaintenanceList");
		ArrayList<Maintenance> maintenanceList = maintenanceService.findAllActiveMaintenances();		
		mav.addObject("maintenanceList", maintenanceList);
		return mav;
	}
	
	@RequestMapping(value = "/calendar/maintenance/create", method = RequestMethod.GET)
	public ModelAndView newMaintenancePage() {
		ModelAndView mav = new ModelAndView("MaintenanceFormNew", "maintenance", new Maintenance());
		ArrayList<String> facilityList = facilityService.findAllDistinctFacilityName();		
		ArrayList<String> facilityCourtsList = facilityService.findAllDistinctFacilityCourt();		
		int nextMaintenanceId = maintenanceService.getAllMaintenances().size()+1;		
		ArrayList<Timeslots> timeslotsList = timeslotService.getAllTimeslots();

		mav.addObject("facilityList", facilityList);
		mav.addObject("facilityCourtsList", facilityCourtsList);
		mav.addObject("nextMaintenanceId", nextMaintenanceId);
		mav.addObject("timeslotsList", timeslotsList);


		return mav;
	}

	@RequestMapping(value = "/calendar/maintenance/create", method = RequestMethod.POST)
	public ModelAndView createNewMaintenance(@ModelAttribute @Valid Maintenance maintenance, BindingResult result,
			final RedirectAttributes redirectAttributes,HttpServletRequest request) {
		if (result.hasErrors())
			return new ModelAndView("MaintenanceFormNew");
		ModelAndView mav = new ModelAndView();

		String selFacilityName=request.getParameter("facilityName");
		String selCourtName=request.getParameter("courtName");
		String startTimeSlot=request.getParameter("timeslotsName_start");
		String endTimeSlot=request.getParameter("timeslotsName_end");
        
		Integer facilityID = facilityService.findByFacilityCourt(selFacilityName, selCourtName);
		Facility f= facilityService.findFacilityById(facilityID);
		maintenance.setFacilities(f);
		
		Timeslots ts_start = timeslotService.findTimeslotByName(startTimeSlot);
		Timeslots ts_end = timeslotService.findTimeslotByName(endTimeSlot);
		maintenance.setTimeslots_start(ts_start);
		maintenance.setTimeslots_end(ts_end);
		maintenance.setActive(true);
		
		maintenanceService.createMaintenance(maintenance);
		String message = "New maintenance " + maintenance.getMaintenanceid() + " was successfully created.";
		mav.setViewName("redirect:/admin/calendar/maintenance/list");
		return mav;
	}

}

