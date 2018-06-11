package iss.sa46team12.springclub.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Greeting;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.BookingsService;
import iss.sa46team12.springclub.services.FacilityService;
import iss.sa46team12.springclub.services.UserService;

@RestController
@XmlRootElement

//keep this class for obtaining JSON of list of confirmed bookings

public class AdminManageBMController {
	
	@Autowired
	BookingsService bookingService;
	
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value="/admin/manageBM",method = RequestMethod.GET)
    public List<Bookings> getBookingList() {
        System.out.println("==== in greeting ====");
        ArrayList<Bookings> cfmBookingList = new ArrayList<Bookings>();
        cfmBookingList = bookingService.findAllConfirmedBookings();
        
        return cfmBookingList;
    }

}