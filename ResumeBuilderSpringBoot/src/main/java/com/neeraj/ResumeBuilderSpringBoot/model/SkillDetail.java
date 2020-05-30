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



@Entity
@Table(name="SkillDetails")
public class SkillDetail 
{

	@Override
	public String toString() {
		return "SkillDetail [SkillDetailId=" + SkillDetailId + ", name=" + name + ", expxInYear=" + expxInYear
				+ ", expxInMonth=" + expxInMonth + ", level=" + level + ", resumeDetail=" + resumeDetail + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int SkillDetailId;
	
	@NotEmpty(message="This Field Can not be empty ")
	private String name;
	
	@NotEmpty(message="This Field Can not be empty ")
	//@Length(max=4)
	private String expxInYear;
	
	@NotEmpty(message="This Field Can not be empty ")
	//@Length(max=2)
	private String expxInMonth;
	
	@NotEmpty(message="This Field Can not be empty ")
	private String level;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="resumeDetailId")
	private ResumeDetail resumeDetail;

	
	public ResumeDetail getResumeDetail() {
		return resumeDetail;
	}

	public void setResumeDetail(ResumeDetail resumeDetail) {
		this.resumeDetail = resumeDetail;
	}

	public int getSkillDetailId() {
		return SkillDetailId;
	}

	public void setSkillDetailId(int skillDetailId) {
		SkillDetailId = skillDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getExpxInYear() {
		return expxInYear;
	}

	public void setExpxInYear(String expxInYear) {
		this.expxInYear = expxInYear;
	}

	public String getExpxInMonth() {
		return expxInMonth;
	}

	public void setExpxInMonth(String expxInMonth) {
		this.expxInMonth = expxInMonth;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

   
}
