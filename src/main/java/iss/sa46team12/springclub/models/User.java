package iss.sa46team12.springclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "userid")
	private int userId;
	@Column(name = "fullname")
	private String fullname;
	@Column(name = "email")
	private String email;
	@Column(name = "nric")
	private String nric;
	@Column(name = "dateofbirth")
	private Date dateofbirth;
	@Column(name = "address")
	private String address;
	@Column(name = "gender")
	private String gender;
	@Column(name = "contactno")
	private String contactno;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;
	@Column(name = "active")
	private boolean active;
	
	public User() {
		
	}
	
	public User(int userId, String fullname, String email, String nric, Date dateofbirth, String address, String gender, String contactno, String password, String role, boolean active) {
		this.userId = userId;
		this.fullname = fullname;
		this.email = email;
		this.nric = nric;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.gender = gender;
		this.contactno = contactno;
		this.password = password;
		this.role = role;
		this.active = active;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
	
	
	
	
	
	

}
