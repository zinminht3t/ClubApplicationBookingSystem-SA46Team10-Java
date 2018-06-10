package iss.sa46team12.springclub.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Bookings class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "bookings")
public class Bookings {
	
	public static final String CONFIRMED = "CONFIRMED";
	public static final String CANCELLED = "CANCELLED";
	
	/**Attributes for Booking**/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingid")
	private int bookingid;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "transactiontime")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime transactiontime;
	@Column(name = "userid")
	private int userid;
	@Column(name = "total")
	private int total;
	@Column(name = "status")
	private String status;
	/*Mapping*/
	@OneToMany(mappedBy="booking", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<BookingDetails> bookingEvents = new ArrayList<BookingDetails>();
	
	/**Constructor to Initialize Booking model object**/
	public Bookings() {
	}
	public Bookings(int bookingid) {
		this.bookingid = bookingid;
	}	
	public Bookings(int bookingid, LocalDateTime transactiontime, int userid, int total, String status, ArrayList<BookingDetails> bookings) {
		this.bookingid = bookingid;
		this.transactiontime = transactiontime;
		this.userid = userid;
		this.total = total;
		this.status = status;
		this.bookingEvents.addAll(bookingEvents);
	}
	/**Getter Setters**/
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public LocalDateTime getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(LocalDateTime transactiontime) {
		this.transactiontime = transactiontime;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<BookingDetails> getBookings() {
		return (new ArrayList<BookingDetails>(bookingEvents));
	}
	
	public void setBookings(ArrayList<BookingDetails> bookings) {
		this.bookingEvents.addAll(bookingEvents);
	}
	/**To String**/
	@Override
	public String toString() {
		return "Bookings [bookingid=" + bookingid + ", transactiontime=" + transactiontime + ", userid=" + userid
				+ ", total=" + total + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingid;
		result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + total;
		result = prime * result + ((transactiontime == null) ? 0 : transactiontime.hashCode());
		result = prime * result + userid;
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
		Bookings other = (Bookings) obj;
		if (bookingid != other.bookingid)
			return false;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (total != other.total)
			return false;
		if (transactiontime == null) {
			if (other.transactiontime != null)
				return false;
		} else if (!transactiontime.equals(other.transactiontime))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	
}
//For Git Update
