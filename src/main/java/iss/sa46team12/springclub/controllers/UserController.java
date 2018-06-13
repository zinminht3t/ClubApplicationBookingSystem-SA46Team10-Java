package iss.sa46team12.springclub.controllers;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;
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
import iss.sa46team12.springclub.email.SendEmail;
import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Password;
import iss.sa46team12.springclub.models.Subscription;
import iss.sa46team12.springclub.models.SubscriptionPackage;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.BookingsService;
import iss.sa46team12.springclub.services.SubscriptionPackageService;
import iss.sa46team12.springclub.services.SubscriptionService;
import iss.sa46team12.springclub.services.UserService;
import iss.sa46team12.springclub.validators.PasswordValidator;
import iss.sa46team12.springclub.validators.UserValidator;

@RequestMapping(value = "/user")
@Controller
public class UserController {

	@Autowired
	UserService uService;
	@Autowired
	SubscriptionService sService;
	@Autowired
	SubscriptionPackageService spService;
	@Autowired
	BookingsService bService;
	@Autowired
	private UserValidator uValidator;
	@Autowired
	private PasswordValidator pValidator;

	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}

	@InitBinder("password")
	private void initPasswordBinder(WebDataBinder binder) {
		binder.addValidators(pValidator);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView editProfile(HttpSession session) {
		int userid;
		try {
			userid = (int) session.getAttribute("UserID"); 
		}
		catch(NullPointerException e) {
			userid = 1;
		}
		ModelAndView mav = new ModelAndView("profile", "password", new Password());
		User user = uService.findUserById(userid);

		Subscription sub = sService.findActiveSubscription(userid);
		SubscriptionPackage subpackage = spService.findPackage(sub.getPackageid());

		ArrayList<SubscriptionPackage> activeSubscriptions = spService.findActiveSubscriptionPackages();
		double price1YearD = 0, price3YearsD = 0;
		SubscriptionPackage pyear1 = new SubscriptionPackage();
		SubscriptionPackage pyear3 = new SubscriptionPackage();
		for (SubscriptionPackage subscriptionPackage : activeSubscriptions) {
			if (subscriptionPackage.getPackageyears().equals("1 Year")) {
				price1YearD = subscriptionPackage.getPackageprice();
				pyear1 = subscriptionPackage;
			}
			if (subscriptionPackage.getPackageyears().equals("3 Years")) {
				price3YearsD = subscriptionPackage.getPackageprice();
				pyear3 = subscriptionPackage;
			}
		}
		DecimalFormat fmt = new DecimalFormat("#,##0.00");
		String price1Year = "$" + fmt.format(price1YearD);
		String price3Years = "$" + fmt.format(price3YearsD);

		// Date Difference
		Calendar c = Calendar.getInstance();
		c.setTime(sub.getExpirydate());
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date());// today date
		long dayleft = daysBetween(c, c2);
		mav.addObject("dayleft", dayleft);
		double dayleftint = (double) dayleft;
		// Membership Date Percentage
		double days = 0; // package year in days
		double percentage = 0;
		if (subpackage.getPackageyears().equals("1 Year")) {
			days = 365;
		} else {
			days = 365 * 3;
		}

		if (dayleftint > days) {
			percentage = 100;
		} else {
			percentage = Math.ceil((100 * (dayleft / days)));
		}
		percentage = (int) percentage;

		// get user past and upcoming bookings
		ArrayList<Bookings> bookingslist = bService.getUserBookings(userid);

		ArrayList<Bookings> pastbookings = new ArrayList<Bookings>();
		ArrayList<Bookings> upcomingbookings = new ArrayList<Bookings>();
		LocalDateTime today = LocalDateTime.now();

		for (Bookings b : bookingslist) {
			if (b.getBookings().get(0).getBookingdate().isAfter(today)) {
				upcomingbookings.add(b);
			} else {
				pastbookings.add(b);
			}
		}

		mav.addObject("pastbookings", pastbookings);
		mav.addObject("upcomingbookings", upcomingbookings);
		mav.addObject("oneYear", price1Year);
		mav.addObject("threeYears", price3Years);
		mav.addObject("oneYearPackage", pyear1);
		mav.addObject("threeYearsPackage", pyear3);
		mav.addObject("user", user);
		mav.addObject("subscription", sub);
		mav.addObject("subpackage", subpackage);
		mav.addObject("percentage", percentage);

		return mav;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {

		int userid;
		try {
			userid = (int) session.getAttribute("UserID"); 
		}
		catch(NullPointerException e) {
			userid = 1;
		}
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("showErrorNotification", "error");
			redirectAttributes.addFlashAttribute("NotieTitle", "Error");
			redirectAttributes.addFlashAttribute("NotieMessage",
					"There is something wrong with your user profile form. Please check the error details in the form!");
			return new ModelAndView("redirect:/user/profile");
		}
		ModelAndView mav;
		mav = new ModelAndView("redirect:/user/profile");
		User up = uService.findUserById(userid);
		up.setAddress(user.getAddress());
		up.setContactno(user.getContactno());
		up.setFullname(user.getFullname());
		up.setDateofbirth(user.getDateofbirth());
		up.setEmail(user.getEmail());
		up.setGender(user.getGender());
		up.setNric(user.getNric());
		uService.editUser(up);

		redirectAttributes.addFlashAttribute("showNotification", "success");
		redirectAttributes.addFlashAttribute("NotiTitle", "Success");
		redirectAttributes.addFlashAttribute("NotiMessage", "Your Profile has been updated successfully !");
		return mav;
	}

	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public ModelAndView changePassword(@ModelAttribute @Valid Password password, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {

		ModelAndView mav;
		mav = new ModelAndView("redirect:/user/profile");

		int userid;
		try {
			userid = (int) session.getAttribute("UserID"); 
		}
		catch(NullPointerException e) {
			userid = 1;
		}
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("showErrorNotification", "error");
			redirectAttributes.addFlashAttribute("NotieTitle", "Error");
			redirectAttributes.addFlashAttribute("NotieMessage", "Your Password is Wrong. Please Try again !");
		}

		User u = uService.findUserById(userid);
		u.setPassword(password.getNewpassword());

		uService.editUser(u);

		redirectAttributes.addFlashAttribute("showNotification", "success");
		redirectAttributes.addFlashAttribute("NotiTitle", "Success");
		redirectAttributes.addFlashAttribute("NotiMessage", "Your password has been updated successfully!");

		return mav;
	}

	@RequestMapping(value = "/renewmembership/{selectedPackage}", method = RequestMethod.GET)
	public ModelAndView logic(@PathVariable int selectedPackage, Model model,
			final RedirectAttributes redirectAttributes, HttpSession session) {

		int userid;
		try {
			userid = (int) session.getAttribute("UserID"); 
		}
		catch(NullPointerException e) {
			userid = 1;
		}
		ModelAndView mav;
		mav = new ModelAndView("redirect:/user/profile");
		SubscriptionPackage sp = spService.findPackage(selectedPackage);

		Subscription sub = new Subscription();

		sub = sService.findActiveSubscription(userid);
		Calendar c = Calendar.getInstance();
		c.setTime(sub.getExpirydate());
		c.add(Calendar.DATE, 1);
		Date newStartJoinDate = c.getTime();

		Subscription newSub = new Subscription();
		newSub.setActive(true);
		newSub.setJoindate(newStartJoinDate);
		newSub.setPackageid(1);
		newSub.setUserid(userid);

		if (sp.getPackageyears().equals("1 Year")) {
			newSub.setPackageid(selectedPackage);
			Calendar nc = Calendar.getInstance();
			nc.setTime(newSub.getJoindate());
			nc.add(Calendar.DATE, 365);
			newSub.setExpirydate(nc.getTime());
		} else {
			newSub.setPackageid(selectedPackage);
			Calendar nc = Calendar.getInstance();
			nc.setTime(newSub.getJoindate());
			nc.add(Calendar.DATE, 1095);
			newSub.setExpirydate(nc.getTime());
		}
		User loginuser = uService.findUserById(userid);
		sService.createSubscription(newSub);
		SendEmail.sendEmail("springclub12@gmail.com", loginuser.getEmail(), "Membership Renewal",
				"Hello, Your membership for " + sp.getPackageyears()
						+ " package has been renewed. Enjoy your membership privileges at our club!");
		redirectAttributes.addFlashAttribute("showNotification", "success");
		redirectAttributes.addFlashAttribute("NotiTitle", "Success");
		redirectAttributes.addFlashAttribute("NotiMessage",
				"Your Subscription has been successfully renewed! Thank you for choosing our club!");
		return mav;
	}

	@RequestMapping(value = "/booking/cancel/{bookingid}", method = RequestMethod.GET)
	public ModelAndView cancelBooking(@PathVariable int bookingid, Model model,
			final RedirectAttributes redirectAttributes, HttpSession session) {

		int userid;
		try {
			userid = (int) session.getAttribute("UserID"); 
		}
		catch(NullPointerException e) {
			userid = 1;
		}
		String bookingStatus = "CONFIRMED";

		ModelAndView mav;
		mav = new ModelAndView("redirect:/user/profile");

		Bookings userBooking = bService.findBooking(bookingid);

		BookingDetails userBD = new BookingDetails();

		for (BookingDetails bd : userBooking.getBookings()) {
			userBD = bd;
		}
		LocalDateTime todayplusthreedays = LocalDateTime.now().plusDays(3);
		if (userBooking.getUser().getUserId() != userid || todayplusthreedays.isAfter(userBD.getBookingdate())) {
			redirectAttributes.addFlashAttribute("showErrorNotification", "error");
			redirectAttributes.addFlashAttribute("NotieTitle", "Error");
			redirectAttributes.addFlashAttribute("NotieMessage", "Something went wrong!");
		} else {

			User loginuser = uService.findUserById(userid);

			if (userBooking.getStatus().equals(bookingStatus)) {
				userBooking.setStatus("Cancelled by user");
				bService.changeBooking(userBooking);

				SendEmail.sendEmail("springclub12@gmail.com", loginuser.getEmail(), "Booking Cancellation",
						"Hello, Your booking for " + userBD.getFacility().getFacilityName() + " facility at "
								+ userBD.getBookingdate() + " has been successfully cancelled!");

				redirectAttributes.addFlashAttribute("showNotification", "success");
				redirectAttributes.addFlashAttribute("NotiTitle", "Booking Cancellation");
				redirectAttributes.addFlashAttribute("NotiMessage",
						"Hello, Your booking for " + userBD.getFacility().getFacilityName() + " facility at "
								+ userBD.getBookingdate() + " has been successfully cancelled!");
			}

		}

		return mav;
	}

	public static long daysBetween(Calendar startDate, Calendar endDate) {
		long end = endDate.getTimeInMillis();
		long start = startDate.getTimeInMillis();
		return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
	}
}
