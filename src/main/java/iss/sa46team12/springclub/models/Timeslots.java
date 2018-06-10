package iss.sa46team12.springclub.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Timeslot class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "timeslots")
public class Timeslots {
	/** Attributes  **/
	@Id
	@Column (name ="timeslotid")
	private int timeslotid;
	@Column (name ="time")
	private int time;
	/** Mapping **/
	@JsonManagedReference
	@OneToMany(mappedBy="timeslots", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<BookingDetails> bookingdetails;
	
//	public List<BookingDetails> getBookingdetails() {
//		return (new ArrayList<BookingDetails> (bookingdetails));
//	}
	/** Constructor **/
	public Timeslots() {
		super();
	}
	/** Getter Setter **/
	public int getTimeslotid() {
		return timeslotid;
	}
	public int getTime() {
		return time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingdetails == null) ? 0 : bookingdetails.hashCode());
		result = prime * result + time;
		result = prime * result + timeslotid;
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
		Timeslots other = (Timeslots) obj;
		if (bookingdetails == null) {
			if (other.bookingdetails != null)
				return false;
		} else if (!bookingdetails.equals(other.bookingdetails))
			return false;
		if (time != other.time)
			return false;
		if (timeslotid != other.timeslotid)
			return false;
		return true;
	}
	
}
//for git update
