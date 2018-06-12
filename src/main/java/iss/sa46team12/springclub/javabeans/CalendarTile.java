package iss.sa46team12.springclub.javabeans;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Maintenance;

/**
 * BookingDetails class
 *
 * @version $Revision: 1.0
 */

//working class for admin calendar management

public class CalendarTile {
	
	private ArrayList<BookingDetails> bookingsList;
	private ArrayList<Maintenance> maintenanceList;
	private int tileId;
	
	public CalendarTile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<BookingDetails> getBookingsList(){
		return this.bookingsList;
	}
	
	public void setBookingList(ArrayList<BookingDetails> list){
		this.bookingsList=list;
	}
	
	public ArrayList<Maintenance> getMaintenanceList(){
		return this.maintenanceList;
	}
	
	public void setMaintenanceList(ArrayList<Maintenance> list){
		this.maintenanceList=list;
	}
	
	public int getTileId(){
		return this.tileId;
	}
	
	public void setTileId(int tileId){
	    this.tileId=tileId;
	}
	
	
	

}
