package iss.sa46team12.springclub.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import iss.sa46team12.springclub.models.Subscription;
import iss.sa46team12.springclub.models.SubscriptionPackage;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.SubscriptionPackageService;
import iss.sa46team12.springclub.services.SubscriptionService;
import iss.sa46team12.springclub.services.UserService;
import iss.sa46team12.springclub.validators.UserValidator;

@Controller
public class RegisterController {

	@Autowired
	private UserService uService;

	@Autowired
	private SubscriptionPackageService sPackageService;

	@Autowired
	private SubscriptionService sService;

	@Autowired
	private UserValidator uValidator;

	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}

	@RequestMapping(value = "/register/{selectedPackage}", method = RequestMethod.GET)
	public ModelAndView logic(@PathVariable String selectedPackage, Model model) {

		ModelAndView mav = new ModelAndView("register", "user", new User());
		model.addAttribute("packageSelected", selectedPackage);

		ArrayList<SubscriptionPackage> activeSubscriptions = sPackageService.findActiveSubscriptionPackages();
		double price1YearD = 0, price3YearsD = 0;

		for (SubscriptionPackage subscriptionPackage : activeSubscriptions) {
			if (subscriptionPackage.getPackageyears().equals("1 Year")) {
				price1YearD = subscriptionPackage.getPackageprice();
			} else {
				price3YearsD = subscriptionPackage.getPackageprice();
			}
		}

		DecimalFormat fmt = new DecimalFormat("#,##0.00");

		String price1Year = "$" + fmt.format(price1YearD);
		String price3Years = "$" + fmt.format(price3YearsD);

		model.addAttribute("oneYear", price1Year);
		model.addAttribute("threeYears", price3Years);

		return mav;
	}

	@RequestMapping(value = "/register/{selectedPackage}", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();

		if (result.hasErrors())
			return new ModelAndView("register");

		String message = "New user " + user.getUserId() + " was successfully created.";

		String dayOfBirth = request.getParameter("dayOfBirth");
		String monthOfBirth = request.getParameter("monthOfBirth");
		String yearOfBirth = request.getParameter("yearOfBirth");

		int day = Integer.parseInt(dayOfBirth);
		int month = Integer.parseInt(monthOfBirth);
		int year = Integer.parseInt(yearOfBirth);

		Calendar cal = new GregorianCalendar(year, month - 1, day);
		Date date = cal.getTime();
		user.setDateofbirth(date);

		user.setRole("member");
		user.setActive(true);

		uService.createUser(user);

		// Update Subscription table

		Subscription newSubscription = new Subscription();

		ArrayList<SubscriptionPackage> activeSubscriptions = sPackageService.findActiveSubscriptionPackages();

		int price1YearID = 0, price3YearsID = 0;

		for (SubscriptionPackage subscriptionPackage : activeSubscriptions) {
			if (subscriptionPackage.getPackageyears().equals("1 Year")) {
				price1YearID = subscriptionPackage.getPackageid();
			} else {
				price3YearsID = subscriptionPackage.getPackageid();
			}
		}

		User createdUser = uService.findByEmail(user.getEmail());
		// System.out.println("Id is " + createdUser.getUserId());
		newSubscription.setUserid(createdUser.getUserId());

		String chosenPackage = request.getParameter("chosen-package");
		// System.out.println(chosenPackage);

		int yearSubscribe = 0;

		if (chosenPackage.equals("package1")) {
			yearSubscribe = 1;
			newSubscription.setPackageid(price1YearID);
		} else {
			yearSubscribe = 3;
			newSubscription.setPackageid(price3YearsID);
		}

		Calendar currCal = Calendar.getInstance();
		Date joinDate = currCal.getTime();
		currCal.add(Calendar.YEAR, yearSubscribe);
		Date expiryDate = currCal.getTime();

		newSubscription.setJoindate(joinDate);
		newSubscription.setExpirydate(expiryDate);
		newSubscription.setActive(true);

		sService.createSubscription(newSubscription);

		// Login after registering
		UserSession us = new UserSession();
		User u = uService.findByEmail(user.getEmail());
		us.setUser(u);
		us.setSessionId(session.getId());
		session.setAttribute("Role", "member");
		session.setAttribute("UserID", u.getUserId());

		mav.setViewName("redirect:/");

		SendEmail.sendEmail("spring12@gmail.com", user.getEmail(), "Spring Club - Welcome",
				"Thank you for signing up with Spring Club!");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}