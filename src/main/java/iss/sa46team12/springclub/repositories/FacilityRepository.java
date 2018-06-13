package iss.sa46team12.springclub.repositories;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Facility;


public interface FacilityRepository extends JpaRepository<Facility, String> {
	
	@Query("SELECT f from Facility f WHERE f.facilityName = :fname")
	ArrayList<Facility> getAllCourtsInFacility(@Param("fname") String fname);
}


