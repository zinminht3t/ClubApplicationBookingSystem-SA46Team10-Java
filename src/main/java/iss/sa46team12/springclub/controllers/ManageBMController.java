
package iss.sa46team12.springclub.controllers;

import java.text.DateFormatSymbols;
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

/***controller class for admin to manage bookings and maintenances****/

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

	/******** Manage Bookings ********/

	@RequestMapping(value = "/viewBookings", method = RequestMethod.GET)
	public ModelAndView listAllCfmBookings() {
		ModelAndView mav = new ModelAndView("bookings");
		ArrayList<Bookings> bookingList = bookingService.findAllConfirmedBookings();
		mav.addObject("bookingList", bookingList);
		return mav;
	}
	

	@RequestMapping(value = "/viewBookings", method = RequestMethod.POST, params = "btnShowBookings")
	public ModelAndView viewBookings() {
		ModelAndView mav = new ModelAndView("bookings");
		ArrayList<Bookings> bookingList = bookingService.findAllConfirmedBookings();
		mav.addObject("bookingList", bookingList);
		return mav;
	}

	
	/******** Edit Bookings ********/

	@RequestMapping(value = "/viewBookings/editBooking/{bookingID}", method = RequestMethod.GET)
	public ModelAndView editMaintenance(@PathVariable Integer bookingID) {
		ModelAndView mav = new ModelAndView("adminBookingForm");
		Bookings booking = bookingService.findBooking(bookingID);
		mav.addObject("booking", booking);
		return mav;
	}

	@RequestMapping(value = "/viewBookings/editBooking/{bookingID}", method = RequestMethod.POST)
	public ModelAndView cancelBooking(@ModelAttribute Bookings booking, @PathVariable Integer bookingID) {

		Bookings currBooking = bookingService.findBooking(bookingID);

		currBooking.setStatus("CANCELLED");

		bookingService.changeBooking(currBooking);

		ModelAndView mav = new ModelAndView("redirect:/admin/viewBookings");
		return mav;
	}

	/** Calendar of Maintenances and Bookings ***/

	@RequestMapping(value = "/viewCalendar", method = RequestMethod.GET)
	public ModelAndView viewCalendar(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView("Calendar");

		//to populate day header of calendar
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

		//to get date of 1st day of this month
		Calendar now = Calendar.getInstance();
		int currentMonth = now.get(Calendar.MONTH) + 1;
		int currentYear = now.get(Calendar.YEAR);

		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		String currentMonthName = months[currentMonth - 1];
		session.setAttribute("currentMonthName", currentMonthName);

		Date currentDate = new Date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			currentDate = simpleDateFormat.parse(currentYear + "-" + currentMonth + "-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int currentFirstDayIndex = currentDate.getDay();

		//storing properties of 'date of 1st day of this month' as session variables
		session.setAttribute("currentDate", currentDate);
		session.setAttribute("currentMonth", currentMonth);
		session.setAttribute("currentYear", currentYear);
		session.setAttribute("currentFirstDayIndex", currentFirstDayIndex);
		session.setAttribute("daysOfWeek", daysOfWeek);

		//to retrieve booking list to populate calendar
		ArrayList<BookingView> bookingViewList = bkgViewService.findBookingMinMaxTimeslots();
		mav.addObject("bookingViewList", bookingViewList);
		session.setAttribute("bookingViewList", bookingViewList);

		//get last day of current month
		Date lastDateOfMonth = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.MONTH, +1); 
		c.add(Calendar.DATE, -1); 
		lastDateOfMonth = c.getTime();
		int lastDayOfCurrentMonth = lastDateOfMonth.getDate();
		
		session.setAttribute("lastDayOfCurrentMonth", lastDayOfCurrentMonth);

		//to retrieve maintenance list to populate calendar
		ArrayList<Maintenance> maintenanceList = maintenanceService.findAllActiveMaintenances();
		session.setAttribute("maintenanceList", maintenanceList);
		
		return mav;
	}

	@RequestMapping(value = "/viewCalendar", method = RequestMethod.POST, params = "btnNext")
	public String nextMonthViewed(HttpSession session) {
		
		//parse to get current date stored in session variable
		int mth = (int) session.getAttribute("currentMonth");
		int year = (int) session.getAttribute("currentYear");

		Date date = new Date();

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			date = simpleDateFormat.parse(year + "-" + mth + "-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, +1); //add a month to current date stored in session var
		date = c.getTime();

		int currentMonth = c.get(Calendar.MONTH) + 1;
		int currentYear = c.get(Calendar.YEAR);
		int currentFirstDayIndex = date.getDay();

		//update stored current date variables in session
		session.setAttribute("currentDate", date);
		session.setAttribute("currentMonth", currentMonth);
		session.setAttribute("currentYear", currentYear);
		session.setAttribute("currentFirstDayIndex", currentFirstDayIndex);

		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		String currentMonthName = months[currentMonth - 1];
		session.setAttribute("currentMonthName", currentMonthName);

		Date lastDateOfMonth = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, +1); 
		cal.add(Calendar.DATE, -1); // get last day of selected month
		lastDateOfMonth = cal.getTime();
		int lastDayOfCurrentMonth = lastDateOfMonth.getDate();
		session.setAttribute("lastDayOfCurrentMonth", lastDayOfCurrentMonth);

		return "Calendar";
	}

	@RequestMapping(value = "/viewCalendar", method = RequestMethod.POST, params = "btnPrev")
	public String prevMonth(HttpSession session) {
		
		//re-parse current date stored in session
		int mth = (int) session.getAttribute("currentMonth");
		int year = (int) session.getAttribute("currentYear");

		Date date = new Date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			date = simpleDateFormat.parse(year + "-" + mth + "-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//subtract a month from current date stored in session variable
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		date = c.getTime();

		int currentMonth = c.get(Calendar.MONTH) + 1;
		int currentYear = c.get(Calendar.YEAR);
		int currentFirstDayIndex = date.getDay();

		session.setAttribute("currentDate", date);
		session.setAttribute("currentMonth", currentMonth);
		session.setAttribute("currentYear", currentYear);
		session.setAttribute("currentFirstDayIndex", currentFirstDayIndex);

		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		String currentMonthName = months[currentMonth - 1];
		session.setAttribute("currentMonthName", currentMonthName);

		Date lastDateOfMonth = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, +1); 
		cal.add(Calendar.DATE, -1); // get last day of sel month
		lastDateOfMonth = cal.getTime();
		int lastDayOfCurrentMonth = lastDateOfMonth.getDate();
		session.setAttribute("lastDayOfCurrentMonth", lastDayOfCurrentMonth);

		return "Calendar";
	}


	@RequestMapping(value = "/viewCalendar", method = RequestMethod.POST, params = "btnShowCalendar")
	public ModelAndView showCalendar(HttpSession session) {
		ModelAndView mav = new ModelAndView("Calendar");

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

		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		String currentMonthName = months[currentMonth - 1];
		session.setAttribute("currentMonthName", currentMonthName);

		Date currentDate = new Date();

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			currentDate = simpleDateFormat.parse(currentYear + "-" + currentMonth + "-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int currentFirstDayIndex = currentDate.getDay();

		session.setAttribute("currentDate", currentDate);
		session.setAttribute("currentMonth", currentMonth);
		session.setAttribute("currentYear", currentYear);
		session.setAttribute("currentFirstDayIndex", currentFirstDayIndex);
		session.setAttribute("daysOfWeek", daysOfWeek);

		ArrayList<BookingView> bookingViewList = bkgViewService.findBookingMinMaxTimeslots();
		mav.addObject("bookingViewList", bookingViewList);
		session.setAttribute("bookingViewList", bookingViewList);

		Date lastDateOfMonth = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.MONTH, +1); 
		c.add(Calendar.DATE, -1); // get last day of month
		lastDateOfMonth = c.getTime();
		int lastDayOfCurrentMonth = lastDateOfMonth.getDate();

		session.setAttribute("lastDayOfCurrentMonth", lastDayOfCurrentMonth);

		ArrayList<Maintenance> maintenanceList = maintenanceService.findAllActiveMaintenances();
		session.setAttribute("maintenanceList", maintenanceList);

		return mav;
	}
	
	/*** Manage Maintenance ***/

	@RequestMapping(value = "/viewMaintenances", method = RequestMethod.GET)
	public ModelAndView listAllMaintenances() {
		ModelAndView mav = new ModelAndView("Maintenance");
		ArrayList<Maintenance> maintenanceList = maintenanceService.findAllActiveMaintenances();
		mav.addObject("maintenanceList", maintenanceList);
		return mav;
	}

	@RequestMapping(value = "/viewMaintenances", method = RequestMethod.POST, params = "btnShowMaintenances")
	public ModelAndView viewMaintenances() {
		ModelAndView mav = new ModelAndView("Maintenance");
		ArrayList<Maintenance> maintenanceList = maintenanceService.findAllActiveMaintenances();
		mav.addObject("maintenanceList", maintenanceList);
		return mav;
	}
	
	/*****Create New Maintenance*****/

	@RequestMapping(value = "/viewMaintenances/MaintenanceFormNew/create", method = RequestMethod.POST, params = "btnShowAddMaintenance")
	public String showMaintenance(HttpSession session) {
		return "MaintenanceFormNew";
	}

	@RequestMapping(value = "/viewMaintenances/MaintenanceFormNew", method = RequestMethod.GET)
	public ModelAndView newMaintenancePage() {
		ModelAndView mav = new ModelAndView("MaintenanceFormNew", "maintenance", new Maintenance());
		
		//get database values to populate dropdown lists on view
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

	@RequestMapping(value = "/viewMaintenances/MaintenanceFormNew/create", method = RequestMethod.POST)
	public ModelAndView createNewMaintenance(@ModelAttribute @Valid Maintenance maintenance, BindingResult result,

		final RedirectAttributes redirectAttributes, HttpServletRequest request) {

		if (result.hasErrors())
			return new ModelAndView("MaintenanceFormNew");
		ModelAndView mav = new ModelAndView();
		
		//get selected obj attributes from view
		String selFacilityName = request.getParameter("facilityName");
		String selCourtName = request.getParameter("courtName");
		String startTimeSlot = request.getParameter("timeslotsName_start");
		String endTimeSlot = request.getParameter("timeslotsName_end");
		
		//set selected facility to new Maintenance obj
		Integer facilityID = facilityService.findByFacilityCourt(selFacilityName, selCourtName);
		Facility f = facilityService.findFacilityById(facilityID);
		maintenance.setFacilities(f);

		//set time start and end to new Maintenance obj
		Timeslots ts_start = timeslotService.findTimeslotByName(startTimeSlot);
		Timeslots ts_end = timeslotService.findTimeslotByName(endTimeSlot);
		maintenance.setTimeslots_start(ts_start);
		maintenance.setTimeslots_end(ts_end);
		maintenance.setActive(true);
		
		//save new Maintenance obj into db
		maintenanceService.createMaintenance(maintenance);
		String message = "New maintenance " + maintenance.getMaintenanceid() + " was successfully created.";
		mav.setViewName("redirect:/admin/viewMaintenances");
		return mav;
	}

	
	/*****Edit Maintenance*****/
	
	@RequestMapping(value = "/viewMaintenances/MaintenanceFormEdit/{maintenanceID}", method = RequestMethod.GET)
	public ModelAndView showEditMaintenanceForm(@PathVariable Integer maintenanceID, Model model) {
		ModelAndView mav = new ModelAndView("MaintenanceFormEdit", "maintenance", new Maintenance());
		mav.addObject("maintenance", maintenanceService.findMaintenance(maintenanceID));
		return mav;
	}

	@RequestMapping(value = "/viewMaintenances/MaintenanceFormEdit/{maintenanceID}", method = RequestMethod.POST)
	public ModelAndView editMaintenance(@ModelAttribute Maintenance maintenance, @PathVariable Integer maintenanceID,
			final RedirectAttributes redirectAttributes) {

		Maintenance currMaintenance = maintenanceService.findMaintenance(maintenanceID);
		
		//inactivate selected Maintenance
		currMaintenance.setActive(false);

		maintenanceService.changeMaintenance(currMaintenance);

		ModelAndView mav = new ModelAndView("redirect:/admin/viewMaintenances");
		String message = "Maintenance " + maintenance.getMaintenanceid() + " was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
