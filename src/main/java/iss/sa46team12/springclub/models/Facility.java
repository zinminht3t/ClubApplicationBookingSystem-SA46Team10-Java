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

@Entity
@Table(name="facilities")
public class Facility {
	
	@Id
	@Column(name = "facilityid")
	private int facilityID ;
	@Column(name = "facilityname")
	private String facilityName;
	private String court;
	private Double price;
	private String remark;
	@Column(name = "imagepath")
	private String imagePath;
	private boolean active = true;
	
	@JsonManagedReference
	@OneToMany(mappedBy="facilities", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<BookingDetails> bookingdetails;
	

	//Constructors
	public Facility() {
		super();
	}
		
	public Facility(int facilityID, String facilityName, String court, Double price, String remark, String imagePath,
		boolean active) {
		super();
		this.facilityID = facilityID;
		this.facilityName = facilityName;
		this.court = court;
		this.price = price;
		this.remark = remark;
		this.imagePath = imagePath;
		this.active = active;
	}


	//public Facility(int facilityID, String facilityName, String court, String remark,String imagePath, boolean active, ArrayList<BookingDetails> bookingEvents) {
		//this(facilityID, facilityName, court, remark, imagePath, active);
//		this.bookingEvents.addAll(bookingEvents);
//	}
	
//	
//	
//
//	public List<BookingDetails> getBookingEvents() {
//		return bookingEvents;
//	}
//
//	public void setBookingEvents(List<BookingDetails> bookingEvents) {
//		this.bookingEvents = bookingEvents;
//	}

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
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
		return "Facility [facilityID=" + facilityID + ", facilityName=" + facilityName + ", court=" + court + ", price="
				+ price + ", remark=" + remark + ", imagePath=" + imagePath + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((bookingdetails == null) ? 0 : bookingdetails.hashCode());
		result = prime * result + ((court == null) ? 0 : court.hashCode());
		result = prime * result + facilityID;
		result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		Facility other = (Facility) obj;
		if (active != other.active)
			return false;
		if (bookingdetails == null) {
			if (other.bookingdetails != null)
				return false;
		} else if (!bookingdetails.equals(other.bookingdetails))
			return false;
		if (court == null) {
			if (other.court != null)
				return false;
		} else if (!court.equals(other.court))
			return false;
		if (facilityID != other.facilityID)
			return false;
		if (facilityName == null) {
			if (other.facilityName != null)
				return false;
		} else if (!facilityName.equals(other.facilityName))
			return false;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		return true;
	}
	
}
