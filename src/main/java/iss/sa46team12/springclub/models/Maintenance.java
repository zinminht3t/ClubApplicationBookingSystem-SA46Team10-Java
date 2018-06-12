package iss.sa46team12.springclub.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Bookings class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "maintenances")
public class Maintenance {
	
	/**Attributes for Booking**/
	
	/**for pri key**/
	@Id
	@Column(name = "maintenanceid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maintenanceid;
    
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="timestartid") //name of this tabl's column
	private Timeslots timeslots_start;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="timeendid") //name of this tabl's column
	private Timeslots timeslots_end;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="facilityid")
	private Facility facilities;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date startdate;
	
	@Column(name = "enddate")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date enddate;
	
	@Column(name="active",columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active;
	
	
	/**Constructor to Initialize Booking model object**/
	public Maintenance() {
	}
	
	public Maintenance(int maintenanceid) {
		this.maintenanceid = maintenanceid;
	}	
	
	public Maintenance(int maintenanceid,Facility facilities, Date startdate, Date enddate, Timeslots timeslots_start,Timeslots timeslots_end, boolean active) {
		this.maintenanceid = maintenanceid;
		this.facilities = facilities;
		this.startdate = startdate;
		this.enddate = enddate;
		this.timeslots_start = timeslots_start;
		this.timeslots_end = timeslots_end;

		this.active = active;
	}
	/**Getter Setters**/

	public int getMaintenanceid() {
		return maintenanceid;
	}

	public void setMaintenanceid(int maintenanceid) {
		this.maintenanceid = maintenanceid;
	}

	public Timeslots getTimeslots_start() {
		return timeslots_start;
	}

	public void setTimeslots_start(Timeslots timeslots_start) {
		this.timeslots_start = timeslots_start;
	}

	public Timeslots getTimeslots_end() {
		return timeslots_end;
	}

	public void setTimeslots_end(Timeslots timeslots_end) {
		this.timeslots_end = timeslots_end;
	}

	public Facility getFacilities() {
		return facilities;
	}

	public void setFacilities(Facility facilities) {
		this.facilities = facilities;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
}
