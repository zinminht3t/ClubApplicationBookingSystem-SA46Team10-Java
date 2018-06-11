package iss.sa46team12.springclub.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Bookings class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "bookings")
public class Bookings {
	
	//private static final String CONFIRMED = "CONFIRMED";
	//private static final String CANCELLED = "CANCELLED";
	
	/**Attributes for Booking**/
	
	/**for pri key**/
	@Id
	@Column(name = "bookingid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;
    

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="userid")
	private User users;
	
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "transactiontime")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime transactiontime;
//	@Column(name = "userid")
//	private int userid;
	@Column(name = "total")
	private int total;
	@Column(name = "status")
	private String status;
	
	
	/*Mapping*/
	@JsonManagedReference
	@OneToMany(mappedBy="booking", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<BookingDetails> bookingEvents = new ArrayList<BookingDetails>();
	
	/**Constructor to Initialize Booking model object**/
	public Bookings() {
	}
	public Bookings(int bookingid) {
		this.bookingid = bookingid;
	}	
	public Bookings(int bookingid, LocalDateTime transactiontime, User user, int total, String status, ArrayList<BookingDetails> bookings) {
		this.bookingid = bookingid;
		this.transactiontime = transactiontime;
		this.users = user;
		this.total = total;
		this.status = status;
		this.bookingEvents.addAll(bookings);
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
	
	public User getUser() {
		return users;
	}
	public void setUser(User user) {
		this.users = user;
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
		this.bookingEvents.addAll(bookings);
	}
	/**To String**/

//	@Override
//	public String toString() {
//		return "Bookings [bookingid=" + bookingid + ", transactiontime=" + transactiontime + ", userid=" + userid
//				+ ", total=" + total + ", status=" + status + "]";
//	}
	
}
