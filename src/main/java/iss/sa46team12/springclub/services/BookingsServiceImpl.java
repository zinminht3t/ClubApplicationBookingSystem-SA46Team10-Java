package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.repositories.BookingsRepository;

@Service
public class BookingsServiceImpl implements BookingsService {

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

	// for showing the booking details in user profile
	@Override
	@Transactional
	public ArrayList<Bookings> getUserBookings(int userid) {
		return bookingsRepository.findUserBookings(userid);
	}

}
