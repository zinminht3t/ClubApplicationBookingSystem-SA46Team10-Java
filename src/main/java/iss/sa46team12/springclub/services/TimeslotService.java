package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.Timeslots;

public interface TimeslotService {

	ArrayList<Timeslots> getAllTimeslots();
	Timeslots  getOneTimeSlot(String tvalue);
//	int findTimeslotIdByName(String tName);
//	
//	Timeslots findTimeslotId(int timeslotid);
	Timeslots findTimeslotByName(@Param("tName") String tName);
}
