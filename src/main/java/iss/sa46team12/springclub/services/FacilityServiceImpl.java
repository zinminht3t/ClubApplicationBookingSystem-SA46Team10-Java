package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

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
		
	@Override
	@Transactional
	public Facility findFacilityByName(String name) {
		System.out.println("Facility Name"+name);
		Facility facility = facrepo.findOne(name);
		System.out.println(facility.toString());
		return facility;
	}

	@Override
	@Transactional
	public Facility findFacilityById(String id) {
		System.out.println("Facility ID"+id);
		Facility facility = facrepo.findOne(id);
		System.out.println(facility.toString());
		return facility;
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

}