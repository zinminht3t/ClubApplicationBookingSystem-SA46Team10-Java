package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.Maintenance;
import iss.sa46team12.springclub.repositories.MaintenanceRepository;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

	@Resource
	MaintenanceRepository maintenanceRepository;

	@Override
	@Transactional
	public ArrayList<Maintenance> getAllMaintenances() {

		return (ArrayList<Maintenance>) maintenanceRepository.findAll();
	}

	@Override
	@Transactional
	public ArrayList<Maintenance> findAllActiveMaintenances() {
		// TODO Auto-generated method stub
		return maintenanceRepository.findAllActiveMaintenances();
	}

	@Override
	@Transactional
	public Maintenance findMaintenance(Integer maintenanceId) {

		return maintenanceRepository.findOne(maintenanceId);
	}

	@Override
	@Transactional
	public Maintenance createMaintenance(Maintenance maintenance) {

		return maintenanceRepository.save(maintenance);
	}

	@Override
	@Transactional
	public Maintenance changeMaintenance(Maintenance maintenance) {

		return maintenanceRepository.saveAndFlush(maintenance);
	}

	@Override
	@Transactional
	public void removeMaintenance(Maintenance maintenance) {
		// TODO Auto-generated method stub
		maintenanceRepository.delete(maintenance);
	}

}
