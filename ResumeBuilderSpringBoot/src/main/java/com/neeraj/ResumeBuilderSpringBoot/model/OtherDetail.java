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
@Table(name="OtherDetail")
public class OtherDetail 
{

	@Override
	public String toString() {
		return "OtherDetail [OtherDetailId=" + OtherDetailId + ", name=" + name + ", discription=" + discription
				+ ", year=" + year + ", resumeDetail=" + resumeDetail + "]";
	}

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int OtherDetailId;

	@NotEmpty(message="This field can not be empty")
	@Length(min=2)
	private String name;
	
	
	private String discription;
	
	
	private long year;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="resumeDetailId")
	private ResumeDetail resumeDetail;
	
	
	
	public ResumeDetail getResumeDetail() {
		return resumeDetail;
	}

	public void setResumeDetail(ResumeDetail resumeDetail) {
		this.resumeDetail = resumeDetail;
	}

	public int getOtherDetailId() {
		return OtherDetailId;
	}

	public void setOtherDetailId(int otherDetailId) {
		OtherDetailId = otherDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	
	
	

}
