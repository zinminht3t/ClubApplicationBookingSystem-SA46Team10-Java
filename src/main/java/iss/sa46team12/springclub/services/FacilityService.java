package iss.sa46team12.springclub.services;


import java.util.ArrayList;

import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.User;


public interface FacilityService {

	ArrayList<Facility> findAllFacilities();
	
	ArrayList<Facility> findFacilityByName(String name);

	Facility findFacilityById(String id);	

	Facility createFacility(Facility fac);
	
//	Facility findFacilityByName(String name);
//	

	Facility editFacility(Facility fac);

	ArrayList<Facility> findFacilityByCriteria(Facility facility);
	
	ArrayList<Facility> getAllCourtsInFacility(String fname);


}