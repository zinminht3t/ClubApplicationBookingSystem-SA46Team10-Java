package iss.sa46team12.springclub.models;

import java.io.Serializable;

public class BookingId implements Serializable {

	private int bookingid;
	private int facilityid;
	private int timeslotid;

	/**
	 * BookingId class Creating composite key for the bookingdetails table
	 * 
	 * @version $Revision: 1.0
	 */
	// @Embeddable
	// public class BookingId implements Serializable{
	// /**
	// *
	// */
	// private static final long serialVersionUID = 1L;
	// /**Attributes for BookingId**/
	//
	//
	// @ManyToOne
	// @JoinColumn(name = "bookingid", referencedColumnName="bookingid")
	// private Bookings booking;
	//
	//
	// @ManyToOne
	// @JoinColumn(name="facilityid", referencedColumnName="facilityid")
	// private Facility facility;
	//
	//
	// @ManyToOne
	// @JoinColumn(name="timeslotid", referencedColumnName="timeslotid")
	// private Timeslots timeslots;
	//
	//
	// /**Constructor**/
	// public BookingId(Bookings booking, Facility facility, Timeslots timeslots) {
	// super();
	// this.booking = booking;
	// this.facility = facility;
	// this.timeslots = timeslots;
	// }
	//
	// /**Getters / Setters**/
	// public Bookings getBooking() {
	// return booking;
	// }
	//
	//
	// public void setBooking(Bookings booking) {
	// this.booking = booking;
	// }
	//
	//
	// public Facility getFacility() {
	// return facility;
	// }
	//
	//
	// public void setFacility(Facility facility) {
	// this.facility = facility;
	// }
	//
	//
	// public Timeslots getTimeslots() {
	// return timeslots;
	// }
	//
	//
	// public void setTimeslots(Timeslots timeslots) {
	// this.timeslots = timeslots;
	// }

}
