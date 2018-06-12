package iss.sa46team12.springclub.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iss.sa46team12.springclub.models.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
	//remove this file later
	@Query("SELECT m from Maintenance m WHERE m.active = 1")
	ArrayList<Maintenance> findAllActiveMaintenances();
}
