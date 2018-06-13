package iss.sa46team12.springclub.repositories;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.User;


public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	
	@Query("SELECT f FROM Facility f WHERE f.facilityName=:fname")
	Facility findOneByName(@Param("fname") String facilityName);
		
	
	
}
