package iss.sa46team12.springclub.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
	@EmbeddedId
	private BookingId bookingId;
	@Temporal(TemporalType.TIMESTAMP)
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
	private Timeslots timeslot;
	
	
	
	/**Constructor**/
	public BookingDetails(BookingId bookingId, LocalDateTime bookingdate, double bookingprice, Bookings booking, Timeslots timeslot) {
		super();
		this.bookingId = bookingId;
		this.bookingdate = bookingdate;
		this.bookingprice = bookingprice;
		this.booking = booking;
		this.timeslot = timeslot;
	}
	/**Getter / Setter**/
	public Timeslots getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(Timeslots timeslot) {
		this.timeslot = timeslot;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
		result = prime * result + ((bookingdate == null) ? 0 : bookingdate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bookingprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((timeslot == null) ? 0 : timeslot.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingDetails other = (BookingDetails) obj;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		if (bookingdate == null) {
			if (other.bookingdate != null)
				return false;
		} else if (!bookingdate.equals(other.bookingdate))
			return false;
		if (Double.doubleToLongBits(bookingprice) != Double.doubleToLongBits(other.bookingprice))
			return false;
		if (timeslot == null) {
			if (other.timeslot != null)
				return false;
		} else if (!timeslot.equals(other.timeslot))
			return false;
		return true;
	}
}

//For git update
