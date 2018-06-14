package iss.sa46team12.springclub.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(BookingId.class)
@Table(name = "bookingdetails")
public class BookingDetailsForBookingProcess {

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

	public BookingDetailsForBookingProcess() {
		super();
	}

	public BookingDetailsForBookingProcess(int bookingid, int facilityid, int timeslotid, LocalDateTime bookingdate,
			double bookingprice) {
		super();
		this.bookingid = bookingid;
		this.facilityid = facilityid;
		this.timeslotid = timeslotid;
		this.bookingdate = bookingdate;
		this.bookingprice = bookingprice;
	}

}
