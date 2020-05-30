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

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="EducationDetails")
public class EducationDetail 
{
	
	    @Override
		public String toString() {
			return "EducationDetail [educationDetailId=" + educationDetailId + ", courseName=" + courseName
					+ ", schoolName=" + schoolName + ", yearOfPassing=" + yearOfPassing + ", percentage=" + percentage
					+ ", resumeDetail=" + resumeDetail + "]";
		}

	    
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int educationDetailId;
	    
	    @NotEmpty(message="This field can not empty")
	    @Length(min=1)
	    private String courseName;
	    
	    @NotEmpty(message="This field can not empty")
	    @Length(min=3)
	    private String schoolName;
	    
	    @NotEmpty(message="This field can not empty")
	    private String yearOfPassing;
	   
	    @NotEmpty(message="This field can not empty")
	    private String percentage;

	    @ManyToOne(fetch=FetchType.EAGER,optional=false)
		@JoinColumn(name="resumeDetailId")
		private ResumeDetail resumeDetail;

		public int getEducationDetailId() {
			return educationDetailId;
		}

		public void setEducationDetailId(int educationDetailId) {
			this.educationDetailId = educationDetailId;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public String getSchoolName() {
			return schoolName;
		}

		public void setSchoolName(String schoolName) {
			this.schoolName = schoolName;
		}

		

		public String getYearOfPassing() {
			return yearOfPassing;
		}

		public void setYearOfPassing(String yearOfPassing) {
			this.yearOfPassing = yearOfPassing;
		}

		

		public String getPercentage() {
			return percentage;
		}

		public void setPercentage(String percentage) {
			this.percentage = percentage;
		}

		public ResumeDetail getResumeDetail() {
			return resumeDetail;
		}

		public void setResumeDetail(ResumeDetail resumeDetail) {
			this.resumeDetail = resumeDetail;
		}
	    
	    
	    
		
	    
}
