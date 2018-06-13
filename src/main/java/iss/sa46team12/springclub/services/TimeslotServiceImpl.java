package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.Timeslots;
import iss.sa46team12.springclub.repositories.TimeslotRepository;

@Service
public class TimeslotServiceImpl implements TimeslotService {

	@Resource
	TimeslotRepository timeslot;
	
	@Override
	@Transactional
	public ArrayList<Timeslots> getAllTimeslots() {
		
		return (ArrayList<Timeslots>) timeslot.findAll();
	}

	@Override
	@Transactional
	public Timeslots getOneTimeSlot(String tvalue) {
		return timeslot.getOneTimeSlot(tvalue);
	}

	public Timeslots findTimeslotByName(String tName) {
		// TODO Auto-generated method stub
		return timeslot.findTimeslotByName(tName);
	}


//	@Override
//	public int findTimeslotIdByName(String tName) {
//		// TODO Auto-generated method stub
//		return timeslot.findTimeslotIdByName(tName);
//	}
//
//
//	@Override
//	@Transactional
//	public Timeslots findTimeslotId(int timeslotid) {
//		// TODO Auto-generated method stub
//		return timeslot.findOne(timeslotid);
//	}


}
