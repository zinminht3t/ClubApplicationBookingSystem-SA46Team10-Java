package iss.sa46team12.springclub.models;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * BookingDetails class
 *
 * @version $Revision: 1.0
 */

@Entity
@IdClass(BookingId.class)
@Table(name = "bookingdetails")
public class BookingDetails {
	/**Attributes for BookingDetails**/
   @Id
   @Column(insertable = false, updatable = false)
   private int bookingid;
   @Id
   @Column(insertable = false, updatable = false)
   private int facilityid;
   @Id
   @Column(insertable = false, updatable = false)
   private int timeslotid;
	
	@Column(name = "bookingdate")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDateTime bookingdate;
	@Column(name = "bookingprice")
	private double bookingprice;
	
	/*Reverse Mapping */
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "bookingid")
	private Bookings booking;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="timeslotid")
	private Timeslots timeslots;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="facilityid")
	private Facility facilities;
	
	/**Constructor to Initialize Booking model object**/
	public BookingDetails() {
	}
	
	/**Constructor**/
	public BookingDetails(int bookingId, LocalDateTime bookingdate, Facility facilities, double bookingprice, Bookings booking, Timeslots timeslot) {
		super();
		this.bookingid = bookingId;
		this.bookingdate = bookingdate;
		this.bookingprice = bookingprice;
		this.booking = booking;
		this.facilities=facilities;
		this.timeslots = timeslot;
			}

	/**Getter / Setter**/
	
	public Timeslots getTimeslot() {
		return timeslots;
	}
	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(int facilityid) {
		this.facilityid = facilityid;
	}

	public int getTimeslotid() {
		return timeslotid;
	}

	public void setTimeslotid(int timeslotid) {
		this.timeslotid = timeslotid;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public Timeslots getTimeslots() {
		return timeslots;
	}

	public void setTimeslots(Timeslots timeslots) {
		this.timeslots = timeslots;
	}

	public Facility getFacilities() {
		return facilities;
	}

	public void setFacilities(Facility facilities) {
		this.facilities = facilities;
	}

	public void setTimeslot(Timeslots timeslot) {
		this.timeslots = timeslot;
	}
	
	public Facility getFacility() {
		return facilities;
	}
	public void setFacility(Facility facility) {
		this.facilities = facility;
	}
	
	
	public void setBookingId(int bookingId) {
		this.bookingid = bookingId;
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
	
	
	@Override
	public String toString() {

		return "BookingDetails [bookingId=" + bookingid + ", bookingdate=" + bookingdate + ", bookingprice="
				+ bookingprice + ", booking=" + booking + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((bookingdate == null) ? 0 : bookingdate.hashCode());
		result = prime * result + bookingid;
		long temp;
		temp = Double.doubleToLongBits(bookingprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + facilityid;
		result = prime * result + timeslotid;
		result = prime * result + ((timeslots == null) ? 0 : timeslots.hashCode());
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
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (bookingdate == null) {
			if (other.bookingdate != null)
				return false;
		} else if (!bookingdate.equals(other.bookingdate))
			return false;
		if (bookingid != other.bookingid)
			return false;
		if (Double.doubleToLongBits(bookingprice) != Double.doubleToLongBits(other.bookingprice))
			return false;
		if (facilityid != other.facilityid)
			return false;
		if (timeslotid != other.timeslotid)
			return false;
		if (timeslots == null) {
			if (other.timeslots != null)
				return false;
		} else if (!timeslots.equals(other.timeslots))
			return false;
		return true;
	}
	
}
