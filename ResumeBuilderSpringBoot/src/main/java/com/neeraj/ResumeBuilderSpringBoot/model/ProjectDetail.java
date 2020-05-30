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
@Table(name="ProjectDetails")
public class ProjectDetail 
{

	
	
	@Override
	public String toString() {
		return "ProjectDetail [ProjectDetailId=" + ProjectDetailId + ", projectName=" + projectName
				+ ", projectDiscription=" + projectDiscription + ", year=" + year + ", resumeDetail=" + resumeDetail
				+ "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int ProjectDetailId;
	
	
	@NotEmpty(message="This Field Can not be empty")
	@Length(min=4)
	private String projectName;

	@NotEmpty(message="This Field Can not be empty")
	@Length(min=4,max=1200)
	private String projectDiscription;

	@NotEmpty(message="This Field Can not be empty")
	private String year;

	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="resumeDetailId")
	private ResumeDetail resumeDetail;
	
	
	public ResumeDetail getResumeDetail() {
		return resumeDetail;
	}

	public void setResumeDetail(ResumeDetail resumeDetail) {
		this.resumeDetail = resumeDetail;
	}

	public int getProjectDetailId() {
		return ProjectDetailId;
	}

	public void setProjectDetailId(int projectDetailId) {
		ProjectDetailId = projectDetailId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDiscription() {
		return projectDiscription;
	}

	public void setProjectDiscription(String projectDiscription) {
		this.projectDiscription = projectDiscription;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	

	

}
