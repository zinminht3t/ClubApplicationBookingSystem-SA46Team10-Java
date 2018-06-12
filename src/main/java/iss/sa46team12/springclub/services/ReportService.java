package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.User;

public interface ReportService {
	
	//facilities
	ArrayList<Facility> findAllFacilities();	
	Facility findFacilityByName(String name);
	Facility findFacilityById(int id);	
	ArrayList<Facility> findFacilityByCriteria(Facility facility);
	
	//users
	int findNumOfMales();
	int findNumOfFemales();
	User findUserById(Integer id);		
	ArrayList<User> getAllUsers();
	
	//bookings
	ArrayList<Bookings> getAllBookings();	
	ArrayList<Bookings> findAllConfirmedBookings();	
	Bookings findBooking(Integer bookingid);	
	Bookings createBooking(Bookings booking);
	Bookings changeBooking(Bookings booking);
	void removeBooking(Bookings booking);
}