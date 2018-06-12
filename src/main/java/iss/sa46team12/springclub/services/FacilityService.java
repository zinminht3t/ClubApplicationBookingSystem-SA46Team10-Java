package iss.sa46team12.springclub.services;


import java.util.ArrayList;

import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.User;


public interface FacilityService {

	ArrayList<Facility> findAllFacilities();
	
	
//	Facility findFacilityByName(String name);
//
	Facility findFacilityById(Integer fid);		
	
	Facility createFacility(Facility f);

	Facility editFacility(Facility fac);

	ArrayList<Facility> findFacilityByCriteria(Facility facility);


}