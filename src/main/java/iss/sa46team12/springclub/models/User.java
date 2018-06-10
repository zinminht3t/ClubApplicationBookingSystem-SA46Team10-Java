package iss.sa46team12.springclub.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{

	@Id
	private Integer userId;
	private String fullName;
	private String email;
	private String nric;
	private Date dateOfBirth;
	private String address;
	private String gender;
	private String contactNo;
	private String password;
	private String role;
	
	
	public int getUserid() {
		return userId;
	}

	public void setUserid(int userid) {
		this.userId = userid;
	}


	public String getFullname(){
		return fullName;
	}

	public void setFullname(String fullname){
		this.fullName=fullname;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getNric(){
		return nric;
	}

	public void setNric(String nric){
		this.nric=nric;
	}

	public java.util.Date getDateofbirth(){
		return dateOfBirth;
	}

	public void setDateofbirth(java.util.Date dateofbirth){
		this.dateOfBirth=dateofbirth;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public String getGender(){
		return gender;
	}

	public void setGender(String gender){
		this.gender=gender;
	}

	public String getContactno(){
		return contactNo;
	}

	public void setContactno(String contactno){
		this.contactNo=contactno;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getRole(){
		return role;
	}

	public void setRole(String role){
		this.role=role;
	}
}