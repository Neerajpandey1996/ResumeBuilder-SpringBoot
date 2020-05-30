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
@Table(name="WorkExprDetails")
public class WorkExprDetail 
{
	@Override
	public String toString() {
		return "WorkExprDetail [WorkExprDetailId=" + WorkExprDetailId + ", orgName=" + orgName + ", fromYear="
				+ fromYear + ", toYear=" + toYear + ", role=" + role + ", Discription=" + discription
				+ ", resumeDetail=" + resumeDetail + "]";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int WorkExprDetailId;
	
	@NotEmpty(message="This Field Can not be Empty")
	@Length(min=3)
	private String orgName;
	
	@NotEmpty(message="This Field Can not be Empty")
	private String fromYear;
	
	//@NotEmpty(message="This Field Can not be Empty")
	private String toYear;
	
	@NotEmpty(message="This Field Can not be Empty")
	@Length(min=2)
	private String role;

	@NotEmpty(message="This Field Can not be Empty")
	@Length(min=10,max=1000)
	private String discription;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="resumeDetailId")
	private ResumeDetail resumeDetail;
	
	public ResumeDetail getResumeDetail() {
		return resumeDetail;
	}

	public void setResumeDetail(ResumeDetail resumeDetail) {
		this.resumeDetail = resumeDetail;
	}

	public int getWorkExprDetailId() {
		return WorkExprDetailId;
	}

	public void setWorkExprDetailId(int workExprDetailId) {
		WorkExprDetailId = workExprDetailId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getFromYear() {
		return fromYear;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public String getToYear() {
		return toYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	
	
}
