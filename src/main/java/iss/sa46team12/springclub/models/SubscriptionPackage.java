package iss.sa46team12.springclub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptionpackages")
public class SubscriptionPackage {
	
	@Id
	@Column(name = "packageid")
	private int packageid;
	@Column(name = "packageyears")
	private String packageyears;
	@Column(name = "packageprice")
	private Double packageprice;
	@Column(name = "active")
	private boolean active;
	
	public int getPackageid() {
		return packageid;
	}
	public void setPackageid(int packageid) {
		this.packageid = packageid;
	}
	public String getPackageyears() {
		return packageyears;
	}
	public void setPackageyears(String packageyears) {
		this.packageyears = packageyears;
	}
	public Double getPackageprice() {
		return packageprice;
	}
	public void setPackageprice(Double packageprice) {
		this.packageprice = packageprice;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	

}
