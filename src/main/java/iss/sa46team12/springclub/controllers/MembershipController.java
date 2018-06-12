package iss.sa46team12.springclub.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import iss.sa46team12.springclub.models.SubscriptionPackage;
import iss.sa46team12.springclub.services.SubscriptionPackageService;

@Controller
public class MembershipController {
	
	@Autowired
	private SubscriptionPackageService sPackageService;
	
	@RequestMapping(value = "/membership")
	public String logic(Model model) {		
		
		ArrayList<SubscriptionPackage> activeSubscriptions = sPackageService.findActiveSubscriptionPackages();
		double price1YearD=0, price3YearsD=0;
		
		for (SubscriptionPackage subscriptionPackage : activeSubscriptions) {
			if(subscriptionPackage.getPackageyears().equals("1 Year")) {
				price1YearD = subscriptionPackage.getPackageprice();
			}
			else {
				price3YearsD = subscriptionPackage.getPackageprice();
			}				
		}
		
		DecimalFormat fmt = new DecimalFormat("#,##0.00");
		
		String price1Year = "$" + fmt.format(price1YearD);
		String price3Years = "$" + fmt.format(price3YearsD);
		
		model.addAttribute("oneYear", price1Year);
		model.addAttribute("threeYears", price3Years);
			
		return "membership";
	}


}