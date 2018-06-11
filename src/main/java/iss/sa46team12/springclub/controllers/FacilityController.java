package iss.sa46team12.springclub.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import iss.sa46team12.springclub.services.FacilityService; 

@RequestMapping("/facility")
@Controller
public class FacilityController {

	@Autowired
	FacilityService facService;
	
}
