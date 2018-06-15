
package iss.sa46team12.springclub.services;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.BookingView;

public interface BookingViewService {

	ArrayList<BookingView> findBookingMinMaxTimeslots();

}
