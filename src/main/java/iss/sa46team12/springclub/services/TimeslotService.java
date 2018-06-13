package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.Timeslots;

public interface TimeslotService {

	ArrayList<Timeslots> getAllTimeslots();
	
	Timeslots  getOneTimeSlot(String tvalue);
}
