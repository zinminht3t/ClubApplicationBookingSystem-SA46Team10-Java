package iss.sa46team12.springclub.models;


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BookingId class
 * Creating composite key for the bookingdetails table
 * @version $Revision: 1.0
 */
@Embeddable
public class BookingId {
	/**Attributes for BookingId**/
	@Column(name = "bookingid")
	private int bookingId;
	@Column(name = "facilityid")
	private int facilityId;
	@Column(name = "timeslotid")
	private int timeslotId;
	public int getBookingId() {
		return bookingId;
	}
	/**Constructor**/
	public BookingId(int bookingId, int facilityId, int timeslotId) {
		super();
		this.bookingId = bookingId;
		this.facilityId = facilityId;
		this.timeslotId = timeslotId;
	}
	/**Getters / Setters**/
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}
	public int getTimeslotId() {
		return timeslotId;
	}
	public void setTimeslotId(int timeslotId) {
		this.timeslotId = timeslotId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		result = prime * result + facilityId;
		result = prime * result + timeslotId;
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
		BookingId other = (BookingId) obj;
		if (bookingId != other.bookingId)
			return false;
		if (facilityId != other.facilityId)
			return false;
		if (timeslotId != other.timeslotId)
			return false;
		return true;
	}
}
//For git
