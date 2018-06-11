package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.*;
import iss.sa46team12.springclub.repositories.BookingsRepository;
import iss.sa46team12.springclub.repositories.FacilityRepository;
import iss.sa46team12.springclub.repositories.ReportRepository;
import iss.sa46team12.springclub.repositories.UserRepository;

@Service
public class ReportServiceImpl implements ReportService {
	
	//facility
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
	
	//users
	@Resource
	UserRepository userRepository;
	
	@Override
	@Transactional
	public int findNumOfMales() {
		return userRepository.countMaleUsers();
	}
	
	@Override
	@Transactional
	public User findUserById(Integer userId) {
		return userRepository.findOne(userId);
	}

	@Override
	@Transactional
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (ArrayList<User>) userRepository.findAll();	
	}
	
	//bookings
	@Resource
	BookingsRepository bookingsRepository;
	
	@Override
	@Transactional
	public ArrayList<Bookings> getAllBookings() {

		return (ArrayList<Bookings>) bookingsRepository.findAll();
	}
	

	@Override
	@Transactional
	public ArrayList<Bookings> findAllConfirmedBookings() {
		// TODO Auto-generated method stub
		return bookingsRepository.findAllConfirmedBookings();
	}


	@Override
	@Transactional
	public Bookings findBooking(Integer bookingid) {
		
		return bookingsRepository.findOne(bookingid);
	}

	@Override
	@Transactional
	public Bookings createBooking(Bookings booking) {
		
		return bookingsRepository.save(booking);
	}

	@Override
	@Transactional
	public Bookings changeBooking(Bookings booking) {

		return bookingsRepository.saveAndFlush(booking);
	}

	@Override
	@Transactional
	public void removeBooking(Bookings booking) {
		// TODO Auto-generated method stub
		bookingsRepository.delete(booking);
	}

}