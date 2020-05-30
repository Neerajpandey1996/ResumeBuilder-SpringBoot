package com.neeraj.ResumeBuilderSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="AddressDetails")
public class AddressDetail 
{

	//toString

	
	@Override
	public String toString() {
		return "AddressDetail [addressId=" + addressId + ", fullName=" + fullName + ", streetAddress=" + streetAddress
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", resumeDetail=" + resumeDetail
				+ "]";
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int addressId;
	
	@NotEmpty(message="Name can not be empty")
	@Length(min=2)
	private String fullName;
	
	@NotEmpty(message="Street Address can not be empty")
	@Length(min=5)
	private String streetAddress;
	
	@NotEmpty(message="City Name can not be empty")
	@Length(min=2)
	private String city;
	
	@NotEmpty(message="State Name can not be empty")
	@Length(min=2)
	private String state;
	
	@NotEmpty(message="Zip Code can not be empty")
	private String zipCode;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="resumeDetailId")
	private ResumeDetail resumeDetail;
	
	//Getters and Setters
	
	public int getAddressId() {
		return addressId;
	}

	public ResumeDetail getResumeDetail() {
		return resumeDetail;
	}

	public void setResumeDetail(ResumeDetail resumeDetail) {
		this.resumeDetail = resumeDetail;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
