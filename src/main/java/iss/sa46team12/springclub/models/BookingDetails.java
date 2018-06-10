package iss.sa46team12.springclub.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * BookingDetails class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "bookingdetails")
public class BookingDetails {
	/**Attributes for BookingDetails**/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingId")
	private int bookingId;
	
	//@EmbeddedId
	//private BookingId bookingId;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bookingdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime bookingdate;
	@Column(name = "bookingprice")
	private double bookingprice;
	public BookingId getBookingId() {
		return bookingId;
	}
	
	/*Reverse Mapping*/
	@ManyToOne
	@JoinColumn(name = "bookingid")
	private Bookings booking;
	
	/** *                        ***/
	/* Facility Mapping code here */
	/* *                        * */
	/***                        ***/
	
	@ManyToOne
	@JoinColumn(name="timeslotid")
	private Timeslots timeslots;
	
	
	
	/**Constructor**/
	public BookingDetails(BookingId bookingId, LocalDateTime bookingdate, double bookingprice, Bookings booking, Timeslots timeslot) {
		super();
		this.bookingId = bookingId;
		this.bookingdate = bookingdate;
		this.bookingprice = bookingprice;
		this.booking = booking;
		this.timeslots = timeslot;
	}
	/**Getter / Setter**/
	public Timeslots getTimeslot() {
		return timeslots;
	}
	public void setTimeslot(Timeslots timeslot) {
		this.timeslots = timeslot;
	}
	public void setBookingId(BookingId bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDateTime getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(LocalDateTime bookingdate) {
		this.bookingdate = bookingdate;
	}
	public double getBookingprice() {
		return bookingprice;
	}
	public void setBookingprice(double bookingprice) {
		this.bookingprice = bookingprice;
	}
	
	public Bookings getBooking() {
		return booking;
	}
	public void setBooking(Bookings booking) {
		this.booking = booking;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", bookingdate=" + bookingdate + ", bookingprice="
				+ bookingprice + ", booking=" + booking + "]";
	}
}
//For git update
