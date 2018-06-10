package iss.sa46team12.springclub.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{

	@Id
	private int userid;
	private String fullname;
	private String email;
	private String nric;
	private Date dateofbirth;
	private String address;
	private String gender;
	private String contactno;
	private String password;
	private String role;
	
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getFullname(){
		return fullname;
	}

	public void setFullname(String fullname){
		this.fullname=fullname;
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
		return dateofbirth;
	}

	public void setDateofbirth(java.util.Date dateofbirth){
		this.dateofbirth=dateofbirth;
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
		return contactno;
	}

	public void setContactno(String contactno){
		this.contactno=contactno;
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