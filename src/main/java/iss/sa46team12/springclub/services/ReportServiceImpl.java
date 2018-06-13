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
import iss.sa46team12.springclub.repositories.ReportMaintenanceRepository;

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
		
//	@Override
//	@Transactional
//	public Facility findFacilityByName(String name) {
//		System.out.println("Facility Name"+name);
//		Facility facility = facrepo.find(name);
//		System.out.println(facility.toString());
//		return facility;
//	}

	@Override
	@Transactional
	public Facility findFacilityById(int id) {
		System.out.println("Facility ID"+id);
		Facility facility = facrepo.findOne(id);
		System.out.println(facility.toString());
		return facility;
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
	public int findNumOfFemales() {
		return userRepository.countFemaleUsers();
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
	
	//custom
	@Resource
	ReportRepository repoRepo;
	
	public int findNumOfBookingsFacil1() {
		return repoRepo.findNumOfBookingsFacil1();
	}
	public int findNumOfBookingsFacil2() {
		return repoRepo.findNumOfBookingsFacil2();
	}
	public int findNumOfBookingsFacil3() {
		return repoRepo.findNumOfBookingsFacil3();
	}
	public int findNumOfBookingsFacil4() {
		return repoRepo.findNumOfBookingsFacil4();
	}	
	
	@Resource
	ReportMaintenanceRepository repoMainRepo;
	
	public int findNumActMainFacil1() {
		return repoMainRepo.findActiveMaintainFacil1();
	}
	
	public int findNumActMainFacil2() {
		return repoMainRepo.findActiveMaintainFacil2();
	}
	
	public int findNumActMainFacil3() {
		return repoMainRepo.findActiveMaintainFacil3();
	}
	
	public int findNumActMainFacil4() {
		return repoMainRepo.findActiveMaintainFacil4();
	}
}