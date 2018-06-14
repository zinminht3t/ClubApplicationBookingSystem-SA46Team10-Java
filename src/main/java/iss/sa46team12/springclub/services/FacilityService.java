package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.Facility;

public interface FacilityService {

	ArrayList<Facility> findAllFacilities();

	ArrayList<String> findAllDistinctFacilityName();

	ArrayList<String> findAllDistinctFacilityCourt();

	// Facility findFacilityByName(String name);
	//

	Facility editFacility(Facility fac);

	Integer findByFacilityCourt(String fName, String fCourt);

	ArrayList<Facility> findFacilityByCriteria(Facility facility);

	ArrayList<Facility> getAllCourtsInFacility(String fname);

	Facility findFacilityById(Integer fid);

	Facility createFacility(Facility f);

	ArrayList<Facility> findFacilityByName(String name);

	ArrayList<Facility> findAllActiveFacility();

}