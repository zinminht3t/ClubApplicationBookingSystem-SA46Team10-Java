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
	public int getMaintenanceId() {
		return maintenanceid;
	}
	public void setMaintenanceId(int maintenanceid) {
		this.maintenanceid = maintenanceid;
	}
	
	public Facility getFacility() {
		return this.facilities;
	}
	
	public void setFacility(Facility f) {
		this.facilities=f;
	}
	
	public Date getStartDate() {
		return this.startdate;
	}
	
	public void setStartDate(Date startDate) {
	    this.startdate=startDate;
	}
	
	public Date getEndDate() {
		return this.enddate;
	}
	
	public void setEndDate(Date endDate) {
	    this.enddate=endDate;
	}
	
	public Timeslots getStartTimeSlot() {
		return this.timeslots_start;
	}
	
	public void setStartTimeSlot(Timeslots timeslot) {
		this.timeslots_start=timeslot;
	}
	
	public Timeslots getEndTimeSlot() {
		return this.timeslots_end;
	}
	
	public void setEndTimeSlot(Timeslots timeslot) {
		this.timeslots_end=timeslot;
	}
	
	public boolean getActiveStatus() {
		return this.active;
	}
	
	public void setActiveState(boolean active) {
		this.active=active;
	}
	
}
