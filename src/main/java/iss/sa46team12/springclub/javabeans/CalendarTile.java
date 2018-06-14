package iss.sa46team12.springclub.javabeans;

import java.util.ArrayList;

import iss.sa46team12.springclub.models.BookingDetails;
import iss.sa46team12.springclub.models.Maintenance;

/**
 * BookingDetails class
 *
 * @version $Revision: 1.0
 */

// working class for admin calendar management

public class CalendarTile {

	private ArrayList<BookingDetails> bookingsList;
	private ArrayList<Maintenance> maintenanceList;
	private int tileId;

	public CalendarTile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<BookingDetails> getBookingsList() {
		return this.bookingsList;
	}

	public void setBookingList(ArrayList<BookingDetails> list) {
		this.bookingsList = list;
	}

	public ArrayList<Maintenance> getMaintenanceList() {
		return this.maintenanceList;
	}

	public void setMaintenanceList(ArrayList<Maintenance> list) {
		this.maintenanceList = list;
	}

	public int getTileId() {
		return this.tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
	}

}
