package iss.sa46team12.springclub.controllers;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

import iss.sa46team12.springclub.models.Password;
import iss.sa46team12.springclub.models.Subscription;
import iss.sa46team12.springclub.models.SubscriptionPackage;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.SubscriptionPackageService;
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
	SubscriptionPackageService spService;
	@Autowired
	private UserValidator uValidator;

	@InitBinder("userProfile")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView editProfile() {

		int userid = 1;// todo
		int subid = 1;// todo
		ModelAndView mav = new ModelAndView("profile", "changeUserPassword", new Password());
		User userProfile = uService.findUserById(userid);
		
		Subscription sub = sService.findActiveSubscription(userid);
		SubscriptionPackage subpackage = spService.findPackage(sub.getPackageid());
		mav.addObject("userProfile", userProfile);
		mav.addObject("subscription", sub);
		mav.addObject("subpackage", subpackage);
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
		mav.addObject("oneYear", price1Year);
		mav.addObject("threeYears", price3Years);
		mav.addObject("oneYearPackage", pyear1);
		mav.addObject("threeYearsPackage", pyear3);
		
		
		//Date Difference
		Calendar c = Calendar.getInstance();
		c.setTime(sub.getExpirydate());
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date());//today date
		long dayleft = daysBetween(c, c2);
		mav.addObject("dayleft", dayleft);
		double dayleftint = (double) dayleft;
		//Membership Date Percentage
		double days = 0; //package year in days
		double percentage = 0;
		if(subpackage.getPackageyears().equals("1 Year")) {
			days = 365;
		}
		else {
			days = 365 * 3;
		}
		
		if(dayleftint > days) {
			percentage = 100;
		}
		else {
			percentage = Math.ceil((100 * (dayleft / days)));
		}
		percentage = (int) percentage;
		mav.addObject("percentage", percentage);
		
		return mav;

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		int userid = 1; // todo
		if (result.hasErrors())
			return new ModelAndView("profile");

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
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("profile");

		ModelAndView mav;
		mav = new ModelAndView("redirect:/user/profile");

		return mav;
	}

	@RequestMapping(value = "/renewmembership/{selectedPackage}", method = RequestMethod.GET)
	public ModelAndView logic(@PathVariable int selectedPackage, Model model,
			final RedirectAttributes redirectAttributes) {

		int userid = 1; // todo
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

		sService.createSubscription(newSub);

		redirectAttributes.addFlashAttribute("showNotification", "success");
		redirectAttributes.addFlashAttribute("NotiTitle", "Success");
		redirectAttributes.addFlashAttribute("NotiMessage",
				"Your Subscription has been successfully renewed! Thank you for choosing our club!");
		return mav;
	}
	
	public static long daysBetween(Calendar startDate, Calendar endDate) {
	    long end = endDate.getTimeInMillis();
	    long start = startDate.getTimeInMillis();
	    return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
	}
}
