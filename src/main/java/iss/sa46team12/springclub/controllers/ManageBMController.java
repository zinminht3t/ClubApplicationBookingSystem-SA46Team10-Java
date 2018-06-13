
package iss.sa46team12.springclub.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import iss.sa46team12.springclub.models.BookingView;
import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.Maintenance;
import iss.sa46team12.springclub.models.Timeslots;

import iss.sa46team12.springclub.services.BookingDetailsService;
import iss.sa46team12.springclub.services.BookingViewService;
import iss.sa46team12.springclub.services.BookingsService;
import iss.sa46team12.springclub.services.FacilityService;
import iss.sa46team12.springclub.services.MaintenanceService;
import iss.sa46team12.springclub.services.TimeslotService;


//controller class for admin to manage bookings and maintenances

@RequestMapping("/admin")
@Controller

@Scope("session")

public class ManageBMController {

	@Autowired
	BookingsService bookingService;

	@Autowired
	MaintenanceService maintenanceService;

	@Autowired
	FacilityService facilityService;

	@Autowired
	TimeslotService timeslotService;

	@Autowired
	BookingDetailsService bkgDetailsService;

	@Autowired
	BookingViewService bkgViewService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
		int nextMaintenanceId = maintenanceService.getAllMaintenances().size() + 1;

		ArrayList<Timeslots> timeslotsList = timeslotService.getAllTimeslots();

		mav.addObject("facilityList", facilityList);
		mav.addObject("facilityCourtsList", facilityCourtsList);
		mav.addObject("nextMaintenanceId", nextMaintenanceId);
		mav.addObject("timeslotsList", timeslotsList);

		return mav;
	}

	@RequestMapping(value = "/calendar/maintenance/create", method = RequestMethod.POST)
	public ModelAndView createNewMaintenance(@ModelAttribute @Valid Maintenance maintenance, BindingResult result,

			final RedirectAttributes redirectAttributes, HttpServletRequest request) {

		if (result.hasErrors())
			return new ModelAndView("MaintenanceFormNew");
		ModelAndView mav = new ModelAndView();

		String selFacilityName = request.getParameter("facilityName");
		String selCourtName = request.getParameter("courtName");
		String startTimeSlot = request.getParameter("timeslotsName_start");
		String endTimeSlot = request.getParameter("timeslotsName_end");

		Integer facilityID = facilityService.findByFacilityCourt(selFacilityName, selCourtName);
		Facility f = facilityService.findFacilityById(facilityID);
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
	


	@RequestMapping(value = "/viewCalendar", method = RequestMethod.GET)
	public ModelAndView viewCalendar(HttpSession session) {
		ModelAndView mav = new ModelAndView("Calendar");
		ArrayList<Bookings> bookingList = bookingService.findAllConfirmedBookings();
		ArrayList<String> daysOfWeek = new ArrayList<String>() {
			{
				add("Sun");
				add("Mon");
				add("Tue");
				add("Wed");
				add("Thu");
				add("Fri");
				add("Sat");
			}
		};

		Calendar now = Calendar.getInstance();
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);

		Date currentDate = new Date();

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			currentDate = simpleDateFormat.parse(currentYear + "-" + currentMonth + "-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int currentFirstDayIndex = currentDate.getDay();

		session.setAttribute("currentDate", currentDate);
		session.setAttribute("currentMonth", currentMonth);
		session.setAttribute("currentYear", currentYear);
		session.setAttribute("currentFirstDayIndex", currentFirstDayIndex);
		session.setAttribute("daysOfWeek", daysOfWeek);

//		mav.addObject("bookingList", bookingList);

		ArrayList<BookingView> bookingViewList = bkgViewService.findBookingMinMaxTimeslots();
		mav.addObject("bookingViewList", bookingViewList);
		session.setAttribute("bookingViewList", bookingViewList);

		
		//end parsing//
		Date lastDateOfMonth = new Date();
		//add a month to current session variable//
		Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);    
		c.add(Calendar.MONTH, +1);   //get next month date as of 01 day 
		c.add(Calendar.DATE, -1);   //get next month date as of 01 day 
		lastDateOfMonth = c.getTime();
		int lastDayOfCurrentMonth = lastDateOfMonth.getDate();
		//end adding//
		
		session.setAttribute("lastDayOfCurrentMonth", lastDayOfCurrentMonth);

		ArrayList<Maintenance> maintenanceList = maintenanceService.findAllActiveMaintenances();
		session.setAttribute("maintenanceList", maintenanceList);

		return mav;
	}

	@RequestMapping(value="/viewCalendar", method = RequestMethod.POST, params = "btnNext")
	public String nextTime(HttpSession session) {
//		Date date = (Date) session.getAttribute("currentDate");
		
		//to parse session date parts (int) to a valid date//
		int mth = (int) session.getAttribute("currentMonth");
		int year = (int) session.getAttribute("currentYear");
		
		Date date = new Date();

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			date = simpleDateFormat.parse(year + "-" + mth + "-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//end parsing//
		
		//add a month to current session variable//
		Calendar c = Calendar.getInstance();
	    c.setTime(date);    
		c.add(Calendar.MONTH, +1);    
		date = c.getTime();
		//end adding//
		
		//get dayOfWeek,month and year index from added date//
		int currentMonth = c.get(Calendar.MONTH) + 1;
		int currentYear = c.get(Calendar.YEAR);
		int currentFirstDayIndex = date.getDay();
		
		session.setAttribute("currentDate", date);
		session.setAttribute("currentMonth", currentMonth);
		session.setAttribute("currentYear", currentYear);
		session.setAttribute("currentFirstDayIndex", currentFirstDayIndex);


		//end parsing//
		Date lastDateOfMonth = new Date();
		//add a month to current session variable//
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);    
		cal.add(Calendar.MONTH, +1);   //get next month date as of 01 day 
		cal.add(Calendar.DATE, -1);   //get next month date as of 01 day 
		lastDateOfMonth = cal.getTime();
		int lastDayOfCurrentMonth = lastDateOfMonth.getDate();
		//end adding//
		
		session.setAttribute("lastDayOfCurrentMonth", lastDayOfCurrentMonth);
		
		return "Calendar";
	}
	
	@RequestMapping(value="/viewCalendar", method = RequestMethod.POST, params = "btnPrev")
	public String prevTime(HttpSession session) {
//		Date date = (Date) session.getAttribute("currentDate");
		
		//to parse session date parts (int) to a valid date//
		int mth = (int) session.getAttribute("currentMonth");
		int year = (int) session.getAttribute("currentYear");
		
		Date date = new Date();

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			date = simpleDateFormat.parse(year + "-" + mth + "-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//end parsing//
		
		//add a month to current session variable//
		Calendar c = Calendar.getInstance();
	    c.setTime(date);    
		c.add(Calendar.MONTH, -1);    
		date = c.getTime();
		//end adding//
		
		//get dayOfWeek,month and year index from added date//
		int currentMonth = c.get(Calendar.MONTH) + 1;
		int currentYear = c.get(Calendar.YEAR);
		int currentFirstDayIndex = date.getDay();
		
		session.setAttribute("currentDate", date);
		session.setAttribute("currentMonth", currentMonth);
		session.setAttribute("currentYear", currentYear);
		session.setAttribute("currentFirstDayIndex", currentFirstDayIndex);

		//end parsing//
		Date lastDateOfMonth = new Date();
		//add a month to current session variable//
		Calendar cal = Calendar.getInstance();
	    cal.setTime(date);    
		cal.add(Calendar.MONTH, +1);   //get next month date as of 01 day 
		cal.add(Calendar.DATE, -1);   //get next month date as of 01 day 
		lastDateOfMonth = cal.getTime();
		int lastDayOfCurrentMonth = lastDateOfMonth.getDate();
		//end adding//
		
		session.setAttribute("lastDayOfCurrentMonth", lastDayOfCurrentMonth);
		
		return "Calendar";
	}
	
	@RequestMapping(value="/calendar/maintenance/create", method = RequestMethod.POST, params = "btnShowAddMaintenance")
	public String showMaintenance(HttpSession session) {
//		Date date = (Date) session.getAttribute("currentDate");
		
		//to parse session date parts (int) to a valid date//
		
		
		return "MaintenanceFormNew";
	}
	

}
