package iss.sa46team12.springclub.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="facilities")
public class Facility {
	
	@Id
	private int facilityID ;
	private String facilityName;
	private String court;
	private String remark;
	private String imagePath;
	private boolean active = true;
	
	@OneToMany(mappedBy="bookingCompositeId.facility", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<BookingDetails> bookingEvents;
	
	
	//Constructors
	public Facility() {
		super();
	}
	
	public Facility(int facilityID, String facilityName, String court, String remark,String imagePath, boolean active) {
		super();
		this.facilityID = facilityID;
		this.facilityName = facilityName;
		this.court = court;
		this.remark = remark;
		this.imagePath = imagePath;
		this.active = active;
		
	}
	
	public Facility(int facilityID, String facilityName, String court, String remark,String imagePath, boolean active, ArrayList<BookingDetails> bookingEvents) {
		this(facilityID, facilityName, court, remark, imagePath, active);
		this.bookingEvents.addAll(bookingEvents);
	}
	
	
	

	public List<BookingDetails> getBookingEvents() {
		return bookingEvents;
	}

	public void setBookingEvents(List<BookingDetails> bookingEvents) {
		this.bookingEvents = bookingEvents;
	}

	//Getters & Setters
	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getCourt() {
		return court;
	}

	public void setCourt(String court) {
		this.court = court;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Facility [facilityID=" + facilityID + ", facilityName=" + facilityName + ", court=" + court
				+ ", remark=" + remark + ", images=" + imagePath + ", active=" + active + "]";
	}

	
	
	
}
