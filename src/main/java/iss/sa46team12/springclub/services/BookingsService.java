package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.Bookings;

public interface BookingsService {

	ArrayList<Bookings> getAllBookings();

	ArrayList<Bookings> findAllConfirmedBookings();

	Bookings findBooking(Integer bookingid);

	Bookings createBooking(Bookings booking);

	Bookings changeBooking(Bookings booking);

	void removeBooking(Bookings booking);

	// for bookings in user profile
	ArrayList<Bookings> getUserBookings(int userid);

}
