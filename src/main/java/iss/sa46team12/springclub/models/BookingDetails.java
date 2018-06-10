package iss.sa46team12.springclub.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	private BookingId bookingCompositeId;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bookingdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime bookingdate;
	@Column(name = "bookingprice")
	private double bookingprice;
	public BookingId getBookingId() {
		return bookingCompositeId;
	}
	
	
	/**Constructor**/
	public BookingDetails(BookingId bookingId, LocalDateTime bookingdate, double bookingprice) {
		super();
		this.bookingCompositeId = bookingId;
		this.bookingdate = bookingdate;
		this.bookingprice = bookingprice;
	}
	/**Getter / Setter**/
	public void setBookingId(BookingId bookingId) {
		this.bookingCompositeId = bookingId;
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
		return "BookingDetails [bookingId=" + bookingCompositeId + ", bookingdate=" + bookingdate + ", bookingprice="
				+ bookingprice + "]";
	}
}
//For git update
