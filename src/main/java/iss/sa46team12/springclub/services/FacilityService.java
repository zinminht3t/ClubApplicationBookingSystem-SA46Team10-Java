package iss.sa46team12.springclub.services;


import java.util.ArrayList;

import iss.sa46team12.springclub.models.Facility;


public interface FacilityService {

	ArrayList<Facility> findAllFacilities();
	
	Facility findFacilityByName(String name);

	Facility findFacilityById(String id);	

	Facility createFacility(Facility fac);

	Facility editFacility(Facility fac);

	ArrayList<Facility> findFacilityByCriteria(Facility facility);


	

}