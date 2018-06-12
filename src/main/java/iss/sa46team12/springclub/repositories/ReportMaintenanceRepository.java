package iss.sa46team12.springclub.repositories;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iss.sa46team12.springclub.models.Maintenance;

public interface ReportMaintenanceRepository extends JpaRepository<Maintenance, Integer> {
	//remove this file later
	@Query("SELECT m from Maintenance m WHERE m.active = 1")
	ArrayList<Maintenance> findAllActiveMaintenances();
	
	@Query("SELECT Count(DISTINCT m.facilities) from Maintenance m WHERE m.active = 1")
	int num();
	
	@Query("SELECT Count(m) from Maintenance m WHERE m.active = 1 and facilities = 1")
	int findActiveMaintainFacil1();
	
	@Query("SELECT Count(m) from Maintenance m WHERE m.active = 1 and facilities = 2")
	int findActiveMaintainFacil2();
	
	@Query("SELECT Count(m) from Maintenance m WHERE m.active = 1 and facilities = 3")
	int findActiveMaintainFacil3();
	
	@Query("SELECT Count(m) from Maintenance m WHERE m.active = 1 and facilities = 4")
	int findActiveMaintainFacil4();
}
