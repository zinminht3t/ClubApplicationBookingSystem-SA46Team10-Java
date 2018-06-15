package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.Maintenance;

public interface MaintenanceService {

	ArrayList<Maintenance> getAllMaintenances();

	ArrayList<Maintenance> findAllActiveMaintenances();

	Maintenance findMaintenance(Integer maintenanceId);

	Maintenance createMaintenance(Maintenance maintenance);

	Maintenance changeMaintenance(Maintenance maintenance);

	void removeMaintenance(Maintenance maintenance);

}
