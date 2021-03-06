package iss.sa46team12.springclub.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	@Query("SELECT DISTINCT f.facilityName from Facility f")
	ArrayList<String> findAllDistinctFacilityName();

	@Query("SELECT f FROM Facility f WHERE f.facilityName=:fname")
	Facility findOneByName(@Param("fname") String facilityName);

	@Query("SELECT DISTINCT f.court from Facility f")
	ArrayList<String> findAllDistinctFacilityCourt();

	@Query("SELECT f.facilityID from Facility f WHERE f.facilityName = :fName AND f.court = :fCourt")
	Integer findByFacilityCourt(@Param("fName") String fName, @Param("fCourt") String fCourt);

	@Query("SELECT f from Facility f WHERE f.facilityName = :fname")
	ArrayList<Facility> getAllCourtsInFacility(@Param("fname") String fname);

	@Query("SELECT f from Facility f WHERE f.active = 1 GROUP BY f.facilityName")
	ArrayList<Facility> getAllActiveFacility();
}
