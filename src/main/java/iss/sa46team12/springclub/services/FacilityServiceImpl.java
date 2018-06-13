package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.repositories.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Resource
	FacilityRepository facrepo;
	
	@Override
	@Transactional
	public ArrayList<Facility> findAllFacilities() {
		return (ArrayList<Facility>) facrepo.findAll();	
		}
	
//	@Override
//	@Transactional
//	public Facility findFacilityByName(String name) {		
//		Facility facility = facrepo.findOne(name);	
//		return facility;
//	}
	
	@Override
	@Transactional
	public Facility findFacilityById(Integer fid) {
		return facrepo.findOne(fid);		 
	}
	
	@Override
	@Transactional
	public Facility createFacility(Facility fac) {
		return facrepo.saveAndFlush(fac);
	}

	@Override
	@Transactional
	public Facility editFacility(Facility fac) {
		return facrepo.saveAndFlush(fac);
	}
	
	@Override
	@Transactional
	public ArrayList<Facility> findFacilityByCriteria(Facility facility) {
		return null;
	}
	
	@Override
	@Transactional
	public ArrayList<Facility> getAllCourtsInFacility(String fname){
		
		return facrepo.getAllCourtsInFacility(fname);
	}

	//Return Null???
	@Override
	public ArrayList<Facility> findFacilityByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ArrayList<String> findAllDistinctFacilityName() {
		// TODO Auto-generated method stub
		return (ArrayList<String>) facrepo.findAllDistinctFacilityName();	
	}

	@Override
	@Transactional
	public ArrayList<String> findAllDistinctFacilityCourt() {
		// TODO Auto-generated method stub
		return (ArrayList<String>) facrepo.findAllDistinctFacilityCourt();	
	}

	@Override
	@Transactional
	public Integer findByFacilityCourt(String fName, String fCourt) {
		// TODO Auto-generated method stub
		return facrepo.findByFacilityCourt(fName, fCourt);
	}

	@Override
	public ArrayList<Facility> findAllActiveFacility() {
		// TODO Auto-generated method stub
		return facrepo.getAllActiveFacility();
	}

}
