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

}
