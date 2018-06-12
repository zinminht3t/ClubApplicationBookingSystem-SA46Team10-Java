package iss.sa46team12.springclub.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@JsonManagedReference
	@OneToMany(mappedBy="timeslots_start", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Maintenance> maintenanceList;
	
	@JsonManagedReference
	@OneToMany(mappedBy="timeslots_end", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Maintenance> maintenanceList2;
	
	
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
	
}
//for git update
