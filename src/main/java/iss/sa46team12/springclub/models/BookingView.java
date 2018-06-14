package iss.sa46team12.springclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * BookingDetails class
 *
 * @version $Revision: 1.0
 */

@Entity
// @IdClass(BookingId.class)
@Table(name = "new_view")
public class BookingView {
	/** Attributes for BookingDetails **/
	@Id
	@Column(name = "bookingid")
	private int bookingid;

	@Column(name = "bookingdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookingdate;

	@Column(name = "minTimeslotId")
	private int minTimeslotId;

	@Column(name = "maxTimeslotId")
	private int maxTimeslotId;

	@Column(name = "minTime")
	private String minTime;

	@Column(name = "maxTime")
	private String maxTime;

	/** Constructor to Initialize Booking model object **/
	public BookingView() {
	}

	public BookingView(int bookingid, Date bookingdate, int minTimeslotId, int maxTimeslotId, String minTime,
			String maxTime) {
		super();
		this.bookingid = bookingid;
		this.bookingdate = bookingdate;
		this.minTimeslotId = minTimeslotId;
		this.maxTimeslotId = maxTimeslotId;
		this.minTime = minTime;
		this.maxTime = maxTime;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Date getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}

	public int getMinTimeslotId() {
		return minTimeslotId;
	}

	public void setMinTimeslotId(int minTimeslotId) {
		this.minTimeslotId = minTimeslotId;
	}

	public int getMaxTimeslotId() {
		return maxTimeslotId;
	}

	public void setMaxTimeslotId(int maxTimeslotId) {
		this.maxTimeslotId = maxTimeslotId;
	}

	public String getMinTime() {
		return minTime;
	}

	public void setMinTime(String minTime) {
		this.minTime = minTime;
	}

	public String getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}

	/**
	 * SQL to create View
	 *
	 *
	 * 
	 * 
	 * CREATE VIEW `new_view` AS select `bkg`.`bookingid` AS
	 * `bookingid`,`bkg`.`bookingdate` AS `bookingdate`,`bkg`.`minTimeslotId` AS
	 * `minTimeslotId`, `bkg`.`maxTimeslotId` AS `maxTimeslotId`,`t1`.`time` AS
	 * `minTime`, `t2`.`time` AS `maxTime` from (((select
	 * `bookingdetails`.`bookingid` AS `bookingid`,`bookingdetails`. `bookingdate`
	 * AS `bookingdate`,min(`bookingdetails`.`timeslotid`) AS
	 * `minTimeslotId`,max(`bookingdetails`.`timeslotid`) AS `maxTimeslotId` from
	 * `bookingdetails` where `bookingdetails`.`bookingid` in (select
	 * `b`.`bookingid` from `bookings` `b` where (`b`.`status` like '%CONFIRMED%'))
	 * group by `bookingdetails`.`bookingid`) `bkg` left join `timeslots` `t1`
	 * on((`t1`.`timeslotid` = `bkg`.`minTimeslotId`))) left join `timeslots` `t2`
	 * on((`t2`.`timeslotid` = `bkg`.`maxTimeslotId`)));
	 *
	 * 
	 */

}
